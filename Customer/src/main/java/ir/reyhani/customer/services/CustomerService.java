package ir.reyhani.customer.services;

import ir.reyhani.clients.dto.fraud.FraudCheckResponse;
import ir.reyhani.clients.dto.notification.NotificationRequest;
import ir.reyhani.clients.fraud.FraudClient;
import ir.reyhani.clients.notification.NotificationClient;
import ir.reyhani.customer.models.Customer;
import ir.reyhani.customer.models.dto.CustomerRegistrationRequest;
import ir.reyhani.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ahmadreza Reyhani
 * @since 6/9/2024 - 1:39 PM
 */

@Service
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient, NotificationClient notificationClient) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customer = customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        notificationClient.sendNotification(new NotificationRequest(customer.getId(), customer.getEmail(), "Hello You Added Successfully"));

    }

}
