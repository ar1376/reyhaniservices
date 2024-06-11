package ir.reyhani.clients.fraud;

import ir.reyhani.clients.dto.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Ahmadreza Reyhani
 * @since 6/10/2024 - 2:38 PM
 */

@FeignClient(value = "fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);

}
