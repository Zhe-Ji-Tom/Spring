package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int findBookPriceById(int id) {
        String sql = "SELECT price FROM book WHERE id = ?";
        
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }

    public void updateBookStock(int id) {
        String str = "SELECT stock FROM bookstock WHERE id = ?";
        int num = jdbcTemplate.queryForObject(str, Integer.class, id);
        if(num == 0)
            throw new BookStockException("¿â´æ²»×ã");
            
        String sql = "UPDATE bookstock SET stock = stock-1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateUserBalance(String username, int price) {
        String str = "SELECT balance FROM account WHERE username = ?";
        int num = jdbcTemplate.queryForObject(str, Integer.class, username);
        if(num < price)
            throw new UserAccountException("Óà¶î²»×ã");
        
        String sql = "UPDATE account SET balance = balance-? WHERE username = ?";
        jdbcTemplate.update(sql, price, username);
    }

    
}
