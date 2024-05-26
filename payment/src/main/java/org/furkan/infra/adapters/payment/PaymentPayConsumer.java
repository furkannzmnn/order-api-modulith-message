package org.furkan.infra.adapters.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentPayConsumer {

    @KafkaListener(topics = "payment-pay", groupId = "group_id")
    public void consume(String message) {
        log.info("Consumed message: {}", message);
    }
}
