package App.Application.Controllers;

import App.Domain.Pos.Employee;
import App.Infrastructure.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {



    @Autowired
    private JdbcTemplate databaseConnection;
    private EmployeeRepository employeeRepository;

    public EmployeeController() {
        this.employeeRepository = new EmployeeRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> get(){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        return this.employeeRepository.get();
    }

    @GetMapping("/{ssn}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> get(@PathVariable("ssn") String ssn){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        return this.employeeRepository.get(ssn);
    }

    @PutMapping("/{ssn}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("ssn") String ssn, @RequestBody() Employee employee){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        this.employeeRepository.update(ssn, employee);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Employee employee){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        this.employeeRepository.create(employee);
    }

    @DeleteMapping("/{ssn}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("ssn") String ssn){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        this.employeeRepository.delete(ssn);
    }
}
