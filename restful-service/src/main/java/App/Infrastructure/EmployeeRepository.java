package App.Infrastructure;

import App.Domain.Pos.Employee;
import App.Domain.IEmployeeRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO jb178339.EMPLOYEE VALUES (" +
                "'" + employee.getSsn() + "', " +
                "'" + employee.getName() + "', " +
                "'" + employee.getAge() + "', " +
                "'" + employee.getWage() + "');";
        this.databaseConnection.execute(sql);
        return employee;
    }

    @Override
    public int update(String id, Employee employee) {
        String sql = "UPDATE jb178339.EMPLOYEE SET " +
                "ssn = '" + employee.getSsn() + "', " +
                "name = '" + employee.getName() + "', " +
                "age = '" + employee.getAge() + "', " +
                "wage = '" + employee.getWage() +
                "' WHERE ssn = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM jb178339.EMPLOYEE WHERE Ssn = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Employee> get(String id){
        String sql = "SELECT * FROM jb178339.EMPLOYEE WHERE Ssn = " + id + ";";
        List<Employee> employees = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    @Override
    public List<Employee> get() {
        String sql = "SELECT * FROM jb178339.EMPLOYEE;";
        List<Employee> employees = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }
}
