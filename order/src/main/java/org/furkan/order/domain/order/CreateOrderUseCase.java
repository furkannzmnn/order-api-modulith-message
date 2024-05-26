package org.furkan.order.domain.order;


import io.craftgate.modulith.messaging.api.model.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class CreateOrderUseCase extends Message {

    private String name;
    private BigDecimal price;
    private LocalDateTime eventDate;


}
