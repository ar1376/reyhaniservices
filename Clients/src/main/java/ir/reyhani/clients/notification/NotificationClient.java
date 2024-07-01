package ir.reyhani.clients.notification;

import ir.reyhani.clients.dto.notification.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Ahmadreza Reyhani
 * @since 6/11/2024 - 11:35 AM
 */

@FeignClient(name = "notification", url = "${clients.notification.url}")
public interface NotificationClient {

    @PostMapping("api/v1/send-notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
