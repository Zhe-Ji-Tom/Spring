import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BookShopDao;
import beans.BookShopService;

public class TransactionTest {

    private ApplicationContext context = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    
    {
        context = new ClassPathXmlApplicationContext("jdbc.xml");
        bookShopDao = (BookShopDao) context.getBean("bookShopDao");
        bookShopService = (BookShopService) context.getBean("bookShopService");
    }
    
    @Test
    public void testFindPriceById() {
        System.out.println(bookShopDao.findBookPriceById(1));
    }
    
    @Test
    public void testAccountBalance() {
        bookShopDao.updateUserBalance("AA", 100);
    }
    
    @Test
    public void testBookUpdate() {
        bookShopDao.updateBookStock(1);
    }
    
    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", 1);
    }
    
    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
