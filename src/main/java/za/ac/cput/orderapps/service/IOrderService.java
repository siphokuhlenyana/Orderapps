/*
Author : Siphokuhle Nyana
25/04/26
IOrderService.java
 */

package za.ac.cput.orderapps.service;

import za.ac.cput.orderapps.domain.Order;
import java.util.List;
public interface IOrderService {
    Order create(Order order);
    Order read(String id);
    List<Order> getAll();
    Order update(Order order);
    void delete(String id);
}
