package App.Domain.Pos;

public class Pasta_Rice {
    private String ID_number;
    private String pasta_riceName;
    private int price;
    private String grain;

    public String getID_number() {
        return ID_number;
    }
    public String getPasta_riceName() {
        return pasta_riceName;
    }
    public String getGrain() {
        return grain;
    }
    public int getPrice() {
        return price;
    }


    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setPasta_riceName(String pasta_riceName) {
        this.pasta_riceName = pasta_riceName;
    }

    public void setGrain(String grain) {
        this.grain = grain;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }
}
