package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenericMain {

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("generic.xml");
        
        ChildService childService = (ChildService) context.getBean("childService");
        childService.add();
    }
}
