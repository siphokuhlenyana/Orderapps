package za.ac.cput.orderapps.service;


import za.ac.cput.orderapps.domain.Product;
import java.util.List;
public interface IProductService {
    Product create(Product product);
    Product read(String id);
    List<Product> getAll();
    Product update(Product product);
    void delete(String id);
}
