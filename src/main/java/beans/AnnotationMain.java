package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        
//        TestObject testObject = (TestObject) context.getBean("testObject");
//        System.out.println(testObject);
        
        UserController userController = (UserController) context.getBean("userController");
        System.out.println(userController);
        userController.execute();
        
//        UserService userService = (UserService) context.getBean("userService");
//        System.out.println(userService);
//        
//        UserRepositoryImpl userRepositoryImpl = (UserRepositoryImpl) context.getBean("userRepository");
//        System.out.println(userRepositoryImpl);
    }
}
