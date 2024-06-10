package ir.reyhani.customer.services;

import ir.reyhani.customer.models.Customer;
import ir.reyhani.customer.models.dto.CustomerRegistrationRequest;
import ir.reyhani.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ahmadreza Reyhani
 * @since 6/9/2024 - 1:39 PM
 */

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.save(customer);
    }

}
