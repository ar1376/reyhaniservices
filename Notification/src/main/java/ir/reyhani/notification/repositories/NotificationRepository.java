package ir.reyhani.notification.repositories;

import ir.reyhani.notification.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ahmadreza Reyhani
 * @since 6/11/2024 - 11:17 AM
 */

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
