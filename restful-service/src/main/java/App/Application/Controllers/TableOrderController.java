package App.Application.Controllers;
import App.Domain.Pos.TableOrder;
import App.Infrastructure.TableOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TableOrder")
public class TableOrderController {


    @Autowired
    private JdbcTemplate databaseConnection;
    private TableOrderRepository tableOrderRepository;

    public TableOrderController() {this.tableOrderRepository = new TableOrderRepository();}

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<TableOrder> get(){
        this.tableOrderRepository.setDatabaseConnection(this.databaseConnection);
        return this.tableOrderRepository.get();
    }

    @GetMapping("/{order_number}")
    @ResponseStatus(HttpStatus.OK)
    public List<TableOrder> get(@PathVariable("order_number") String order_number){
        this.tableOrderRepository.setDatabaseConnection(this.databaseConnection);
        return this.tableOrderRepository.get(order_number);
    }
    @PutMapping("/{order_number}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("order_number") String order_number, @RequestBody() TableOrder tableOrder){
        this.tableOrderRepository.setDatabaseConnection(this.databaseConnection);
        this.tableOrderRepository.update(order_number, tableOrder);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() TableOrder tableOrder){
        this.tableOrderRepository.setDatabaseConnection(this.databaseConnection);
        this.tableOrderRepository.create(tableOrder);
    }

    @DeleteMapping("/{order_number}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("order_number") String order_number){
        this.tableOrderRepository.setDatabaseConnection(this.databaseConnection);
        this.tableOrderRepository.delete(order_number);
    }
}
