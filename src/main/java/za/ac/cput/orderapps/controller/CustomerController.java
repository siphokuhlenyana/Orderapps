/*
Author : Siphokuhle Nyana
25/04/26
CustomerController.jav
 */

package za.ac.cput.orderapps.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.orderapps.domain.Customer;
import za.ac.cput.orderapps.service.CustomerService;

import java.util.List;
@RestController
@RequestMapping("/api/order")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping("/{id}")
    public Customer read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/api/customers")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
