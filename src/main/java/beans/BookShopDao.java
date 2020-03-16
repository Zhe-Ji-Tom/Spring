package beans;

public interface BookShopDao {

    public int findBookPriceById(int id);
    
    public void updateBookStock(int id);
    
    public void updateUserBalance(String username, int price);
}
