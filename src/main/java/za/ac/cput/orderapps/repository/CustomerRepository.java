package za.ac.cput.orderapps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.orderapps.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String>{
}
