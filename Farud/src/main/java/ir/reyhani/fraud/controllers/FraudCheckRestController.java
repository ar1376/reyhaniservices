package ir.reyhani.fraud.controllers;

import ir.reyhani.fraud.models.dto.FraudCheckResponse;
import ir.reyhani.fraud.services.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmadreza Reyhani
 * @since 6/10/2024 - 11:21 AM
 */

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudCheckRestController(FraudCheckService fraudCheckService) {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulentCustomer);
    }

}
