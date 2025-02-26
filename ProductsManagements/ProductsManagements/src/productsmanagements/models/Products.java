package productsmanagements.models;

public class Products {
    private String productName;
    private Double price;
    private int lot;
    
    public Products() {}

    public Products(String productName, Double price, int lot) {
        this.productName = productName;
        this.price = price;
        this.lot = lot;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }
}