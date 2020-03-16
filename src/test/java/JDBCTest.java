import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import beans.Cashier;
import beans.Department;

import javax.sql.DataSource;

public class JDBCTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
    private JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = 
        (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");
    private Cashier cashier = (Cashier) context.getBean("cashier");
    
    @Test
    public void testUpdate() {
        String sql = "UPDATE department SET departmentName = 'ee' where id = '4'";
        jdbcTemplate.update(sql);
    }
    
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO department(id, departmentName) VALUES(?, ?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[] {5, "ff"});
        batchArgs.add(new Object[] {6, "gg"});
        
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
    
    @Test
    public void testQueryForObject() {
        String sql = "SELECT id, departmentName FROM department WHERE id = ?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
        Department department = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(department);
    }
    
    @Test
    public void testQueryForList() {
        String sql = "SELECT id, departmentName FROM department WHERE id > ?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
        List<Department> departments = jdbcTemplate.query(sql, rowMapper, 3);
        System.out.println(departments);
    }
    
    @Test
    public void testQueryForCount() {
        String sql = "SELECT COUNT(id) FROM department";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
    
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "INSERT INTO department(id, departmentName) VALUES(:id, :departmentName)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", 7);
        paramMap.put("departmentName", "dd");
        
        namedParameterJdbcTemplate.update(sql, paramMap);
    }
    
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "INSERT INTO department(id, departmentName) VALUES(:id, :departmentName)";
        Department dep = new Department();
        dep.setId(8);
        dep.setDepartmentName("A");
        
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(dep);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }
    
    @Test
    public void testTransactionlPropagation() {
        cashier.checkout("AA", Arrays.asList(1, 2));
    }
    
    @Test
    public void test() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
