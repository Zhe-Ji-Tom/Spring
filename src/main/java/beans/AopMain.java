package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        
        ArithmeticCalculator arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
        int result = arithmeticCalculator.add(3, 6);
        System.out.println(result);
        
        result = arithmeticCalculator.mul(2, 4);
        System.out.println(result);
        
        result = arithmeticCalculator.div(10, 2);
        System.out.println(result);
    }
}
