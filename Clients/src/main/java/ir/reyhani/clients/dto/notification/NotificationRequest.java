package ir.reyhani.clients.dto.notification;

/**
 * @author Ahmadreza Reyhani
 * @since 6/11/2024 - 11:21 AM
 */

public record NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message) {
}
