package App.Infrastructure;

import App.Domain.IPizzaRepository;
import App.Domain.Pos.Pizza;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


public class PizzaRepository implements IPizzaRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Pizza create(Pizza pizza) {
        String sql = "INSERT INTO jb178339.PIZZA VALUES (" +
                "'" + pizza.getID_number() + "', " +
                "'" + pizza.getPizzaName() + "', " +
                "'" + pizza.getPrice() + "', " +
                "'" + pizza.getSauce() + "');";
        this.databaseConnection.execute(sql);
        return pizza;
    }

    @Override
    public int update(String id, Pizza pizza) {
        String sql = "UPDATE jb178339.PIZZA SET " +
                "ID_number = '" + pizza.getID_number() + "', " +
                "pizzaname = '" + pizza.getPizzaName() + "', " +
                "price = '" + pizza.getPrice() + "', " +
                "sauce = '" + pizza.getSauce() +
                "' WHERE ID_number = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM jb178339.PIZZA WHERE ID_number = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Pizza> get(String id) {
        String sql = "SELECT * FROM jb178339.PIZZA WHERE ID_number = " + id + ";";
        List<Pizza> pizzas = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Pizza.class));
        return pizzas;
    }

    @Override
    public List<Pizza> get() {
        String sql = "SELECT * FROM jb178339.PIZZA;";
        List<Pizza> pizzas = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Pizza.class));
        return pizzas;
    }

}
