package org.furkan.order.domain.order;

import io.craftgate.modulith.messaging.api.model.AggregateRoot;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.furkan.order.domain.order.notify.OrderCreateNotifyEvent;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Getter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class Order extends AggregateRoot {
    private String name;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public static Order of(String name, BigDecimal price, LocalDateTime eventDate) {
        return Order.builder()
                .name(name)
                .price(price)
                .eventDate(eventDate)
                .build();
    }


    public static Order create(CreateOrderUseCase message) {

        Order order = Order.builder()
                .name(message.getName())
                .price(message.getPrice())
                .eventDate(message.getEventDate())
                .build();

        order.registerMessage(OrderCreateNotifyEvent.of(order));
        return order;
    }
    public void doNotify() {
        this.registerMessage(OrderCreateNotifyEvent.of(this));
        log.info("Order notified triggered: {}", this);
    }

}
