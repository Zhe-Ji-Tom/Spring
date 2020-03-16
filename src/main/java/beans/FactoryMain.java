package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
        
        Car car = (Car) context.getBean("car1");
        System.out.println(car);
        
        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);
        
        Car car3 = (Car) context.getBean("car3");
        System.out.println(car3);
    }
    
}
