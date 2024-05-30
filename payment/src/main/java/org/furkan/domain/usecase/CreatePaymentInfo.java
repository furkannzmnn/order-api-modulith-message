package org.furkan.domain.usecase;

import io.craftgate.modulith.messaging.api.model.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class CreatePaymentInfo extends Message {

    private String paymentId;
    private String orderId;
    private String paymentStatus;
    private String paymentAmount;
    private String paymentDate;


}
