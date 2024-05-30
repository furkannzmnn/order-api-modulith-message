package org.furkan.infra.adapters.payment.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.furkan.domain.port.PaymentPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static io.craftgate.modulith.messaging.api.MessagePublisher.publishAndGet;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentPayConsumer {

    private final PaymentPort paymentPort;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "payment-pay", groupId = "group_id")
    public void consume(@Payload PaymentCreateEvent event) {
        try {
            log.info("Payment pay event received: {}", event);
            publishAndGet(event.toModel());
        } catch (Exception e) {
            log.warn("Payment pay event is not processed", e);
        }

    }
}
