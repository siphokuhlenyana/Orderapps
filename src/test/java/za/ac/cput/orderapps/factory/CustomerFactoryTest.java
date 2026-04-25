package za.ac.cput.orderapps.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Customer;


import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {
    @Test
    void testCreateCustomer() {
        CustomerName name = new CustomerName.Builder()
                .setFirstName("Athini")
                .setLastName("Ngquke")

                .build();

        Customer customer = CustomerFactory.createCustomer("1", name, "angquke@test.com","123593737");
//Check the diff btwn the Order --> Customer
        assertNull(customer);
    }
}
