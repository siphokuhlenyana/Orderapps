/*
Author : Siphokuhle Nyana
25/04/26
OrderController.jav
 */

package za.ac.cput.orderapps.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.orderapps.domain.Order;
import za.ac.cput.orderapps.service.OrderService;
import java.util.List;


    @RestController
    @RequestMapping("/api/order")
    public class OrderController {

        private final OrderService service;

        public OrderController(OrderService service) {
            this.service = service;
        }

        @PostMapping
        public Order create(@RequestBody Order order) {
            return service.create(order);
        }

        @GetMapping("/{id}")
        public Order read(@PathVariable String id) {
            return service.read(id);
        }

        @GetMapping
        public List<Order> getAll() {
            return service.getAll();
        }

        @PutMapping
        public Order update(@RequestBody Order order) {
            return service.update(order);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable String id) {
            service.delete(id);
        }
}
