package org.furkan.infra.adapters.payment.jpa.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.furkan.domain.Payment;
import org.furkan.domain.usecase.CreatePaymentInfo;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentId;
    private String orderId;
    private String paymentStatus;
    private String paymentAmount;
    private String paymentDate;

    public static PaymentInfoEntity fromModel(CreatePaymentInfo payment) {
        return PaymentInfoEntity.builder()
                .paymentId(payment.getPaymentId())
                .orderId(payment.getOrderId())
                .paymentStatus(payment.getPaymentStatus())
                .paymentAmount(payment.getPaymentAmount())
                .paymentDate(payment.getPaymentDate())
                .build();
    }
}
