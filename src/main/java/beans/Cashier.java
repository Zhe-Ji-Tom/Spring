package beans;

import java.util.List;

public interface Cashier {

    public void checkout(String username, List<Integer> ids);
}
