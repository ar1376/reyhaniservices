package ir.reyhani.notification.controllers;

import ir.reyhani.clients.dto.notification.NotificationRequest;
import ir.reyhani.notification.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmadreza Reyhani
 * @since 6/11/2024 - 11:25 AM
 */

@Slf4j
@RestController
@RequestMapping("api/v1/send-notification")
public record SendNotificationRestController(NotificationService notificationService) {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Send notification request: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }

}
