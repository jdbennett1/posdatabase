package App.Infrastructure;

import App.Domain.IPasta_RiceRepository;
import App.Domain.Pos.Pasta_Rice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


public class Pasta_RiceRepository implements IPasta_RiceRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Pasta_Rice create(Pasta_Rice pasta_rice) {
        String sql = "INSERT INTO jb178339.PASTA_RICE VALUES (" +
                "'" + pasta_rice.getID_number() + "', " +
                "'" + pasta_rice.getPasta_riceName() + "', " +
                "'" + pasta_rice.getPrice() + "', " +
                "'" + pasta_rice.getGrain() + "');";
        this.databaseConnection.execute(sql);
        return pasta_rice;
    }

    @Override
    public int update(String id, Pasta_Rice pasta_rice) {
        String sql = "UPDATE jb178339.PASTA_RICE SET " +
                "ID_number = '" + pasta_rice.getID_number() + "', " +
                "pasta_ricename = '" + pasta_rice.getPasta_riceName() + "', " +
                "price = '" + pasta_rice.getPrice() + "', " +
                "grain = '" + pasta_rice.getGrain() +
                "' WHERE ID_number = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM jb178339.PASTA_RICE WHERE ID_number = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Pasta_Rice> get(String id) {
        String sql = "SELECT * FROM jb178339.PASTA_RICE WHERE ID_number = " + id + ";";
        List<Pasta_Rice> pasta_rices = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Pasta_Rice.class));
        return pasta_rices;
    }

    @Override
    public List<Pasta_Rice> get() {
        String sql = "SELECT * FROM jb178339.PASTA_RICE;";
        List<Pasta_Rice> pasta_rices = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Pasta_Rice.class));
        return pasta_rices;
    }

}
