package org.furkan.order.domain.order.notify;

import io.craftgate.modulith.messaging.api.annotation.MessageType;
import io.craftgate.modulith.messaging.api.model.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.furkan.order.domain.order.Order;

import java.time.LocalDateTime;


@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@MessageType(name = "ORDER_CREATED")
public class OrderCreateNotifyEvent extends Message {

    private String name;
    private String price;
    private String eventDate;
    private String notifyDate;

    public static Message of(Order order) {
        return OrderCreateNotifyEvent.builder()
                .name(order.getName())
                .price(order.getPrice().toString())
                .eventDate(LocalDateTime.now().toString())
                .notifyDate(LocalDateTime.now().toString())
                .build();
    }


}
