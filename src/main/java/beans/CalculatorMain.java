package beans;

public class CalculatorMain {

    public static void main(String[] args) {
        
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy(); 
        
        int result = proxy.add(1, 2);
        System.out.println(result);
        
        result = proxy.mul(2, 3);
        System.out.println(result);
    }
}
