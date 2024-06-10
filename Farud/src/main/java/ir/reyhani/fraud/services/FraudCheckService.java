package ir.reyhani.fraud.services;

import ir.reyhani.fraud.models.FraudCheckHistory;
import ir.reyhani.fraud.repositories.FraudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Ahmadreza Reyhani
 * @since 6/10/2024 - 11:22 AM
 */

@Service
public record FraudCheckService(FraudRepository fraudRepository) {

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFraudster(false)
                .build());
        return false;
    }
}
