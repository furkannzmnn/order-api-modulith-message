package org.furkan.domain.port;

import org.furkan.domain.Payment;
import org.furkan.domain.usecase.CreatePaymentInfo;

public interface PaymentPort {
    Payment create(CreatePaymentInfo paymentCreate);

    Payment retrieve(Long accountId);

}
