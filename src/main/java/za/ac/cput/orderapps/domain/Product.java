/*
Author : Siphokuhle Nyana
29/04/26
Product.java
 */


package za.ac.cput.orderapps.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Product {

    @Id
    private String productId;

     private String productName;

     private double price;
     private int stockQuantity;

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;

    }

    protected Product() {}

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public static class Builder {
        private String productId;
        private String productName;
        private double price;
        private int stockQuantity;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Product build() {
            if (productId == null || productId.isEmpty()) return null;
            if (productName == null) return null;
            if (price <=0 ) return null;
            if (stockQuantity <=0) return null;


            return new Product(this);
        }
    }
}
