package App.Domain.Pos;

public class Pizza {
    private String ID_number;
    private String pizzaName;
    private int price;
    private String sauce;

    public String getID_number() {
        return ID_number;
    }
    public String getPizzaName() {
        return pizzaName;
    }
    public String getSauce() {
        return sauce;
    }
    public int getPrice() {
        return price;
    }


    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }

}
