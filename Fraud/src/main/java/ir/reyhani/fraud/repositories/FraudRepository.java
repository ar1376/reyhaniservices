package ir.reyhani.fraud.repositories;

import ir.reyhani.fraud.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ahmadreza Reyhani
 * @since 6/10/2024 - 11:20 AM
 */

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
