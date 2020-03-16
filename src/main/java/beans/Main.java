package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("tom");
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//        helloWorld.hello();
//        
//        Car car = (Car) context.getBean("car"); 
//        System.out.println(car);
//        
//        People people = (People) context.getBean("people2");
//        System.out.println(people);
//        
//        NewPeople newPeople = (NewPeople) context.getBean("newPeople");
//        System.out.println(newPeople);
//        
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        System.out.println(dataSource.getProperties());
//        
//        People pPeople = (People) context.getBean("pPeople");
//        System.out.println(pPeople);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
        
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        
//        Address address = (Address) context.getBean("address");
//        System.out.println(address);
        Address address = (Address) context.getBean("address2");
        System.out.println(address);
        
    }
}
