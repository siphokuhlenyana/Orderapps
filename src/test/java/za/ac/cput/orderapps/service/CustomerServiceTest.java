/*
Author : Siphokuhle Nyana
25/04/26
CustomerServiceTest
 */

package za.ac.cput.orderapps.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Customer;

import za.ac.cput.orderapps.repository.CustomerRepository;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService service;

    @Test
    void testRead() {
        CustomerName name = new CustomerName.Builder()
                .setFirstName("Mihle")
                .setLastName("Nosilela")
                .build();

        Customer customer = new Customer.Builder()
                .setPatientID("PT1")
                .setCustomerName(name)
                .setEmail("Mihle@nosilela.com")
                .setMobileNumber("0123456789")
                .build();

        Mockito.when(repository.findById("1")).thenReturn(Optional.of(customer));

        Customer result = service.read("1");

        assertNotNull(result);
    }
}
