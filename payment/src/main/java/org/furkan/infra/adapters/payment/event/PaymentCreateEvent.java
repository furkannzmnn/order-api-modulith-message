package org.furkan.infra.adapters.payment.event;

import lombok.Data;
import org.apache.kafka.common.Uuid;
import org.furkan.domain.Payment;
import org.furkan.domain.usecase.CreatePaymentInfo;

@Data
public class PaymentCreateEvent {
    private String paymentId = Uuid.randomUuid().toString();
    private String orderId;
    private String paymentStatus;
    private String paymentAmount;
    private String paymentDate;

    public CreatePaymentInfo toModel() {
        return CreatePaymentInfo.builder()
                .paymentId(paymentId)
                .orderId(orderId)
                .paymentStatus(paymentStatus)
                .paymentAmount(paymentAmount)
                .paymentDate(paymentDate)
                .build();
    }
}
