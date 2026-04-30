/*
Author : Siphokuhle Nyana
30/04/26
ProductServiceTest.java
 */

package za.ac.cput.orderapps.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import za.ac.cput.orderapps.domain.Product;
import za.ac.cput.orderapps.repository.ProductRepository;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void testRead() {

        Product product = new Product.Builder()
                .setProductId("PR3")
                .setStockQuantity(25)
                .setProductName("Cordless mouse")
                .setPrice(23.49)
                .build();

        Mockito.when(repository.findById("PR3")).thenReturn(Optional.of(product));

        Product result = service.read("PR3");

        assertNotNull(result);
    }

}
