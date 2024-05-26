package org.furkan.order.infra.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.furkan.order.domain.order.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public static OrderEntity fromModel(Order orderEntity) {
        OrderEntity entity = new OrderEntity();
        entity.setName(orderEntity.getName());
        entity.setPrice(orderEntity.getPrice());
        entity.setEventDate(orderEntity.getEventDate());
        return entity;
    }

    public Order toModel() {
        return Order.builder()
                .name(name)
                .price(price)
                .eventDate(eventDate)
                .build();
    }
}
