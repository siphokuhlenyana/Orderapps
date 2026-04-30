/*
Author : Siphokuhle Nyana
29/04/26
ProductController.java
 */
package za.ac.cput.orderapps.controller;


import org.springframework.web.bind.annotation.*;
import za.ac.cput.orderapps.domain.Product;
import za.ac.cput.orderapps.service.ProductService;
import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping("/{id}")
    public Product read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/api/customers")
    public List<Product> getAll() {
        return service.getAll();
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
