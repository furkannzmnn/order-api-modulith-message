package org.furkan.domain;

import io.craftgate.modulith.messaging.api.model.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.furkan.domain.usecase.CreatePaymentInfo;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Payment extends AggregateRoot {

    private String paymentId;
    private String orderId;
    private String paymentStatus;
    private String paymentAmount;
    private String paymentDate;

    public static Payment create(CreatePaymentInfo message) {
        return Payment.builder()
                .paymentId(message.getPaymentId())
                .orderId(message.getOrderId())
                .paymentStatus(message.getPaymentStatus())
                .paymentAmount(message.getPaymentAmount())
                .paymentDate(message.getPaymentDate())
                .build();
    }
}
