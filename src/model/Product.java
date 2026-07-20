package model;

public class Product {

    public String productName;
    public int basePrice;

    public Product(String productName, int basePrice) {
        this.productName = productName;
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Product : " + productName +
                "\nBase Price : " + basePrice;
    }
}