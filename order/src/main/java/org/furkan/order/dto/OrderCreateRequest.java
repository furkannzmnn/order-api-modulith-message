package org.furkan.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.furkan.order.domain.order.CreateOrderUseCase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {

    private String name;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public CreateOrderUseCase toUseCase() {
        return CreateOrderUseCase.builder()
                .name(name)
                .price(price)
                .eventDate(eventDate)
                .build();
    }
}
