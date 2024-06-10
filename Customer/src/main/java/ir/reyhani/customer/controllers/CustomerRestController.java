package ir.reyhani.customer.controllers;

import ir.reyhani.customer.models.dto.CustomerRegistrationRequest;
import ir.reyhani.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmadreza Reyhani
 * @since 6/9/2024 - 1:35 PM
 */

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerRestController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Registering new customer {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
