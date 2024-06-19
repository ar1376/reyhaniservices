package ir.reyhani.notification.rabbitmq;

import ir.reyhani.clients.dto.notification.NotificationRequest;
import ir.reyhani.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ahmadreza Reyhani
 * @since 6/19/2024 - 10:30 AM
 */

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Notification consumer called with {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
