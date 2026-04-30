/*
Author : Siphokuhle Nyana
23/04/26
OrderControllerTest
 */

package za.ac.cput.orderapps.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Order;
import za.ac.cput.orderapps.service.IOrderService;
import za.ac.cput.orderapps.service.OrderService;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
    @Mock
    private OrderService service;

    @InjectMocks
    private OrderController controller;

    private Order createTestOrder() {
        CustomerName name = new CustomerName.Builder()
                .setFirstName("Siphokuhle")
                .setMiddleName("Millior")
                .setLastName("Nyana")
                .build();

        return new Order.Builder()
                .setOrderId("1")
                .setCustomerName(name)
                .setDate(new Date())
                .build();
    }

    @Test
    void testCreate() {
        Order order = createTestOrder();

        when(service.create(order)).thenReturn(order);

        Order result = controller.create(order);

        assertNotNull(result);
        assertEquals("1", result.getOrderId());
        verify(service).create(order);
    }

    @Test
    void testRead() {
        Order order = createTestOrder();

        when(service.read("1")).thenReturn(order);

        Order result = controller.read("1");

        assertNotNull(result);
        assertEquals("1", result.getOrderId());
        verify(service).read("1");
    }

    @Test
    void testRead_NotFound() {
        when(service.read("999")).thenReturn(null);

        Order result = controller.read("999");

        assertNull(result);
        verify(service).read("999");
    }

    @Test
    void testGetAll() {
        when(service.getAll()).thenReturn(List.of());
        List<?> result = controller.getAll();
        assertNotNull(result);
        verify(service).getAll();
    }
}