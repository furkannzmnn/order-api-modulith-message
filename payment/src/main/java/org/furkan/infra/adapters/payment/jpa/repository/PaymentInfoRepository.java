package org.furkan.infra.adapters.payment.jpa.repository;

import org.furkan.infra.adapters.payment.jpa.entitiy.PaymentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfoEntity, Long> {
    PaymentInfoEntity findByOrderId(String orderId);
}
