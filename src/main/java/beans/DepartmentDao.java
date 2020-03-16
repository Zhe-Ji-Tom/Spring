package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void getDepartmentName() {
        String sql = "SELECT departName FROM department where id = ?";
        String departmentName = jdbcTemplate.queryForObject(sql, String.class, 1);
        System.out.println(departmentName);
    }
    
}
