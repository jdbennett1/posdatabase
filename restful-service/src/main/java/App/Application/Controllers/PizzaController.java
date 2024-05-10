package App.Application.Controllers;


import App.Domain.Pos.Pizza;
import App.Infrastructure.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pizza")
public class PizzaController {


    @Autowired
    private JdbcTemplate databaseConnection;
    private PizzaRepository pizzaRepository;

    public PizzaController() {this.pizzaRepository = new PizzaRepository();}

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Pizza> get(){
        this.pizzaRepository.setDatabaseConnection(this.databaseConnection);
        return this.pizzaRepository.get();
    }

    @GetMapping("/{ID_number}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pizza> get(@PathVariable("ID_number") String ID_number){
        this.pizzaRepository.setDatabaseConnection(this.databaseConnection);
        return this.pizzaRepository.get(ID_number);
    }
    @PutMapping("/{ID_number}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("ID_number") String ID_number, @RequestBody() Pizza pizza){
        this.pizzaRepository.setDatabaseConnection(this.databaseConnection);
        this.pizzaRepository.update(ID_number, pizza);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Pizza pizza){
        this.pizzaRepository.setDatabaseConnection(this.databaseConnection);
        this.pizzaRepository.create(pizza);
    }

    @DeleteMapping("/{ID_number}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("ID_number") String ID_number){
        this.pizzaRepository.setDatabaseConnection(this.databaseConnection);
        this.pizzaRepository.delete(ID_number);
    }
}
