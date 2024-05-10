package App.Infrastructure;

import App.Domain.ITableOrderRepository;
import App.Domain.Pos.Pizza;
import App.Domain.Pos.TableOrder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


public class TableOrderRepository implements ITableOrderRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public TableOrder create(TableOrder tableOrder) {
        String sql = "INSERT INTO jb178339.TABLEORDER VALUES (" +
                "'" + tableOrder.getOrder_number() + "', " +
                "'" + tableOrder.getMenu_item() + "', " +
                "'" + tableOrder.getPrice() + "', " +
                "'" + tableOrder.getItem_quantity() + "', " +
                "'" + tableOrder.getPrice() * tableOrder.getItem_quantity() + "');";
        this.databaseConnection.execute(sql);
        return tableOrder;
    }

    @Override
    public int update(String id, TableOrder tableOrder) {
        String sql = "UPDATE jb178339.TABLEORDER SET " +
                "order_number = '" + tableOrder.getOrder_number() + "', " +
                "menu_item = '" + tableOrder.getMenu_item() + "', " +
                "price = '" + tableOrder.getPrice() + "', " +
                "item_quantity = '" + tableOrder.getItem_quantity() + "', " +
                "cost = '" + tableOrder.getPrice() * tableOrder.getItem_quantity() +
                "' WHERE order_number = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM jb178339.TABLEORDER WHERE order_number = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<TableOrder> get(String id) {
        String sql = "SELECT * FROM jb178339.TABLEORDER WHERE order_number = " + id + ";";
        List<TableOrder> tableOrders = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(TableOrder.class));
        return tableOrders;
    }

    @Override
    public List<TableOrder> get() {
        String sql = "SELECT * FROM jb178339.TABLEORDER;";
        List<TableOrder> tableOrders = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(TableOrder.class));
        return tableOrders;
    }

}
