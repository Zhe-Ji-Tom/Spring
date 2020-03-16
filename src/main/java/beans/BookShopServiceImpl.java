package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;
    
    @Transactional
    public void purchase(String username, int id) {
        int price = bookShopDao.findBookPriceById(id);
        
        bookShopDao.updateBookStock(id);
        
        bookShopDao.updateUserBalance(username, price);
    }

}
