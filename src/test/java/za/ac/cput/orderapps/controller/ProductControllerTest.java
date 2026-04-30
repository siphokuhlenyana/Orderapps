/*
Author : Siphokuhle Nyana
30/04/26
ProductControllerTest
 */

package za.ac.cput.orderapps.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import za.ac.cput.orderapps.domain.Product;
import za.ac.cput.orderapps.service.IProductService;
import za.ac.cput.orderapps.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    private Product createTestProduct() {
        Product product = new Product.Builder()
                .setProductId("PR1")
                .setProductName("Pencil Case")
                .setPrice(44.99)
                .setStockQuantity(5)
                .build();

        return product;

    }

    @Test
    void testCreate() {
        Product product = createTestProduct();

        when(service.create(product)).thenReturn(product);

        Product result = controller.create(product);

        assertNotNull(result);
        assertEquals("PR1", result.getProductId());
        verify(service).create(product);
    }

    @Test
    void testRead() {
        Product product = createTestProduct();

        when(service.read("PR1")).thenReturn(product);

        Product result = controller.read("PR1");

        assertNotNull(result);
        assertEquals("PR1", result.getProductId());
        verify(service).read("PR1");
    }

    @Test
    void testRead_NotFound() {
        when(service.read("PR1")).thenReturn(null);

        Product result = controller.read("PR1");

        assertNull(result);
        verify(service).read("PR1");
    }

    @Test
    void testGetAll() {
        when(service.getAll()).thenReturn(List.of());
        List<?> result = controller.getAll();
        assertNotNull(result);
        verify(service).getAll();
    }
}
