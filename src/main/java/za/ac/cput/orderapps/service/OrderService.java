/*
Author : Siphokuhle Nyana
25/04/26
OrderService.java
 */

package za.ac.cput.orderapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.orderapps.domain.Order;
import za.ac.cput.orderapps.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order create(Order order) {
        if (order == null) return null;
        return repository.save(order);
    }

    @Override
    public Order read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order update(Order order) {
        if (order == null) return null;
        return repository.save(order);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
