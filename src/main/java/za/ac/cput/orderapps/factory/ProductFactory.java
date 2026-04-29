/*
Author : Siphokuhle Nyana
29/04/26
ProductFactory
 */


package za.ac.cput.orderapps.factory;


import za.ac.cput.orderapps.domain.Product;
public class ProductFactory {

    public static   Product createProduct(String  productId, String productName ,double price , int stockQuantity) {
        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .build();
    }
}
