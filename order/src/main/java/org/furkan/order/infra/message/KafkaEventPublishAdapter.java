package org.furkan.order.infra.message;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.furkan.order.domain.order.notify.OrderCreateNotifyEvent;
import org.furkan.order.domain.order.notify.OrderEventPublishPort;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
@ConditionalOnProperty(name = "kafka.enabled", havingValue = "true")
public class KafkaEventPublishAdapter implements OrderEventPublishPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String topic, String message) {
        log.info("Sending message to topic: {} message: {}", topic, message);
        kafkaTemplate.send(topic, message);
    }

    @Override
    public void publish(OrderCreateNotifyEvent orderCreateNotifyEvent) {
        publish("payment-pay", orderCreateNotifyEvent.toString());
    }
}
