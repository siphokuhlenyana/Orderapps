/*
Author : Siphokuhle Nyana
25/04/26
OrderRepository.java ---
 */
package za.ac.cput.orderapps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.orderapps.domain.Order;
public interface OrderRepository extends JpaRepository<Order, String>  {

}
