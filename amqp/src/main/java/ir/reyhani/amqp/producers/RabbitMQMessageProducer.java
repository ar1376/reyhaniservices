package ir.reyhani.amqp.producers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ahmadreza Reyhani
 * @since 6/18/2024 - 3:25 PM
 */

@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing message to exchange {} with routingKey {}. Payload : {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload, message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
            return message;
        });
        log.info("Published message to exchange {} with routingKey {}. Payload : {}", exchange, routingKey, payload);
    }

}
