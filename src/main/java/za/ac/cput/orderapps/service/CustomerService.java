/*
Author : Siphokuhle Nyana
25/04/26
CustomerService.java
 */
package za.ac.cput.orderapps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.orderapps.domain.Customer;
import za.ac.cput.orderapps.repository.CustomerRepository;


import java.util.List;
@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer create(Customer customer) {
        if (customer == null) return null;
        return repository.save(customer);
    }

    @Override
    public Customer read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        if (customer == null) return null;
        return repository.save(customer);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
