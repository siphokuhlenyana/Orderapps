/*
Author : Siphokuhle Nyana
29/04/26
ProductRepository.java ---
 */

package za.ac.cput.orderapps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.orderapps.domain.Product;
public interface ProductRepository extends JpaRepository<Product, String>  {
}
