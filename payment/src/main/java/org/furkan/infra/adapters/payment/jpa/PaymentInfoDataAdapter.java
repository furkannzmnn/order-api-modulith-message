package org.furkan.infra.adapters.payment.jpa;

import lombok.RequiredArgsConstructor;
import org.furkan.domain.Payment;
import org.furkan.domain.port.PaymentPort;
import org.furkan.domain.usecase.CreatePaymentInfo;
import org.furkan.infra.adapters.payment.jpa.entitiy.PaymentInfoEntity;
import org.furkan.infra.adapters.payment.jpa.repository.PaymentInfoRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentInfoDataAdapter implements PaymentPort {

    private final PaymentInfoRepository paymentInfoRepository;

    @Override
    public Payment create(CreatePaymentInfo paymentCreate) {
        return toModel(paymentInfoRepository.save(PaymentInfoEntity.fromModel(paymentCreate)));
    }

    @Override
    public Payment retrieve(Long accountId) {
        return paymentInfoRepository.findById(accountId)
                .map(this::toModel)
                .orElse(null);
    }

    private Payment toModel(PaymentInfoEntity paymentInfoEntity) {
        return Payment.builder()
                .paymentId(paymentInfoEntity.getPaymentId())
                .paymentAmount(paymentInfoEntity.getPaymentAmount())
                .paymentDate(paymentInfoEntity.getPaymentDate())
                .orderId(paymentInfoEntity.getOrderId())
                .build();
    }

}
