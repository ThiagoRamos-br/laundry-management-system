package model.entities;

public class PieceValue {


    private Double price;

    private Product product;


    public PieceValue(Product product) {
        this.price = 5.0;
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
