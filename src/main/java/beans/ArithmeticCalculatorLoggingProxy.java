package beans;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

    private ArithmeticCalculator calculator;
    
    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator calculator) {
        super();
        this.calculator = calculator;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;
        
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class[] interfaces = new Class[] {ArithmeticCalculator.class};
        InvocationHandler h = new InvocationHandler() {
            
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("The method " + method.getName() + " begins with " + Arrays.asList(args));   
                Object result = method.invoke(calculator, args);
                System.out.println("The method" + method.getName() + " ends with "+ result);
                return result;
            }
        };
        
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
        
        return proxy;
    }
}
