package org.furkan.order.dto;

import lombok.Data;
import org.furkan.order.domain.order.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public static OrderResponse from(Order order) {
        OrderResponse response = new OrderResponse();
        response.setName(order.getName());
        response.setPrice(order.getPrice());
        response.setEventDate(order.getEventDate());
        return response;
    }
}
