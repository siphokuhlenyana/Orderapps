package za.ac.cput.orderapps.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Order;
import za.ac.cput.orderapps.repository.OrderRepository;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService service;

    @Test
    void testRead() {
        CustomerName name = new CustomerName.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        Order order = new Order.Builder()
                .setOrderId("1")
                .setCustomerName(name)
                .setAmount(200)
                .build();

        Mockito.when(repository.findById("1")).thenReturn(Optional.of(order));

        Order result = service.read("1");

        assertNotNull(result);
    }
}
