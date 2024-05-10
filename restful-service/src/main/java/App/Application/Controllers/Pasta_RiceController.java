package App.Application.Controllers;


import App.Domain.Pos.Pasta_Rice;
import App.Infrastructure.Pasta_RiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pasta_rice")
public class Pasta_RiceController {


    @Autowired
    private JdbcTemplate databaseConnection;
    private Pasta_RiceRepository pasta_piceRepository;

    public Pasta_RiceController() {this.pasta_piceRepository = new Pasta_RiceRepository();}

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Pasta_Rice> get(){
        this.pasta_piceRepository.setDatabaseConnection(this.databaseConnection);
        return this.pasta_piceRepository.get();
    }

    @GetMapping("/{ID_number}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pasta_Rice> get(@PathVariable("ID_number") String ID_number){
        this.pasta_piceRepository.setDatabaseConnection(this.databaseConnection);
        return this.pasta_piceRepository.get(ID_number);
    }
    @PutMapping("/{ID_number}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("ID_number") String ID_number, @RequestBody() Pasta_Rice pasta_rice){
        this.pasta_piceRepository.setDatabaseConnection(this.databaseConnection);
        this.pasta_piceRepository.update(ID_number, pasta_rice);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Pasta_Rice pasta_rice){
        this.pasta_piceRepository.setDatabaseConnection(this.databaseConnection);
        this.pasta_piceRepository.create(pasta_rice);
    }

    @DeleteMapping("/{ID_number}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("ID_number") String ID_number){
        this.pasta_piceRepository.setDatabaseConnection(this.databaseConnection);
        this.pasta_piceRepository.delete(ID_number);
    }


}