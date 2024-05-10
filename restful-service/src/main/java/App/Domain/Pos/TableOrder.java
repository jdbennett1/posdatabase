package App.Domain.Pos;

public class TableOrder {
    private String order_number;
    private String menu_item;
    private int price;
    private int item_quantity;
    private int cost;

    public String getOrder_number() {
        return order_number;
    }
    public String getMenu_item() {
        return menu_item;
    }
    public int getItem_quantity() {
        return item_quantity;
    }
    public int getPrice() {
        return price;
    }
    public int getCost() {
        return cost;
    }


    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public void setPizzaName(String pizzaName) {
        this.menu_item = menu_item;
    }

    public void setItem_quantity(String item_quantity) {
        this.item_quantity = Integer.parseInt(item_quantity);
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }

    public void setCost(String cost) {this.cost = Integer.parseInt(cost);}
}
