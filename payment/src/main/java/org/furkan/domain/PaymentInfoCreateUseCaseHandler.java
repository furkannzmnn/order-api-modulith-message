package org.furkan.domain;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import io.craftgate.modulith.messaging.api.annotation.MessageHandlerConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.furkan.domain.port.PaymentPort;
import org.furkan.domain.usecase.CreatePaymentInfo;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
@MessageHandlerConfig(selector = CreatePaymentInfo.class, isTransactional = true)
public class PaymentInfoCreateUseCaseHandler {

    private final PaymentPort paymentPort;

    public Payment handle(CreatePaymentInfo message) {
        paymentPort.create(message);
        log.info("Payment created: {}", message);
        return Payment.create(message);
    }
}
