package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import javax.sql.DataSource;

public class PropertiesMain {

    public static void main(String[] args) throws SQLException {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("properties.xml");
        
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
