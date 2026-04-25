/*
Author : Siphokuhle Nyana
25/04/26
CustomerServiceTest
 */

package za.ac.cput.orderapps.controller;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Customer;
import za.ac.cput.orderapps.service.CustomerService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Mock
    private CustomerService service;

    @InjectMocks
    private CustomerController controller;

    private Customer createTestCustomer() {
        CustomerName name = new CustomerName.Builder()
                .setFirstName("Sipho")
                .setMiddleName("Angie")
                .setLastName("Nyana")
                .build();

        return new Customer.Builder()
                .setPatientID("1")
                .setCustomerName(name)
                .setEmail("testing@gmail.com")
                .setMobileNumber("021 968 4565")
                .build();
    }

    @Test
    void testCreate() {
        Customer customer = createTestCustomer();

        when(service.create(customer)).thenReturn(customer);

        Customer result = controller.create(customer);

        assertNotNull(result);
        assertEquals("1", result.getPatientID());
        verify(service).create(customer);
    }

    @Test
    void testRead() {
        Customer order = createTestCustomer();

        when(service.read("1")).thenReturn(order);

        Customer result = controller.read("1");

        assertNotNull(result);
        assertEquals("1", result.getPatientID());
        verify(service).read("1");
    }

    @Test
    void testRead_NotFound() {
        when(service.read("999")).thenReturn(null);

        Customer result = controller.read("999");

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
