package ir.reyhani.notification.services;

import ir.reyhani.clients.dto.notification.NotificationRequest;
import ir.reyhani.notification.models.Notification;
import ir.reyhani.notification.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Ahmadreza Reyhani
 * @since 6/11/2024 - 11:17 AM
 */

@Service
public record NotificationService(NotificationRepository notificationRepository) {


    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Ahmadreza Service")
                .sendAt(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);
    }
}
