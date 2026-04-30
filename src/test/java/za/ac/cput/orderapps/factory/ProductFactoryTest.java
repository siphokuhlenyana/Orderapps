/*
Author : Siphokuhle Nyana
30/04/26
ProductFactoryTest.java
 */

package za.ac.cput.orderapps.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.orderapps.domain.Product;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductFactoryTest {

    @Test
    void testCreateProduct() {
        Product product = new Product.Builder()
                .setProductId("PR02")
                .setProductName("Headsets")
                .setPrice(150.99)
                .setStockQuantity(100)
                .build();

        Product product2 = ProductFactory.createProduct("PR02","Headsets",150.99 ,100);

        assertNotNull(product);
    }
}
