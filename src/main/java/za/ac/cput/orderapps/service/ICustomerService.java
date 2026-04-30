/*
Author : Siphokuhle Nyana
25/04/26
ICustomerService.java
 */

package za.ac.cput.orderapps.service;

import za.ac.cput.orderapps.domain.Customer;


import java.util.List;

public interface ICustomerService {
    Customer create(Customer customer);
    Customer read(String id);
    List<Customer> getAll();
    Customer update(Customer customer);
    void delete(String id);
}
