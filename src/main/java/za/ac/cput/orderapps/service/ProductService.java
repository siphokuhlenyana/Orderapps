/*
Author : Siphokuhle Nyana
29/04/26
ProductService.java
 */
package za.ac.cput.orderapps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.orderapps.domain.Product;
import za.ac.cput.orderapps.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product create(Product product) {
        if (product == null) return null;
        return repository.save(product);
    }

    @Override
    public Product read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product update(Product product) {
        if (product == null) return null;
        return repository.save(product);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
