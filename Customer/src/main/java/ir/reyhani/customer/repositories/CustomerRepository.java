package ir.reyhani.customer.repositories;

import ir.reyhani.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ahmadreza Reyhani
 * @since 6/9/2024 - 3:04 PM
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
