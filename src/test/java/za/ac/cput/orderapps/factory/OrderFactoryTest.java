package za.ac.cput.orderapps.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

    @Test
    void testCreateOrder() {
        CustomerName name = new CustomerName.Builder()
                .setFirstName("Sino")
                .setLastName("Nkomo")
                .build();

        Order order = OrderFactory.createOrder("1", name, 5000);

        assertNotNull(order);
    }
}
