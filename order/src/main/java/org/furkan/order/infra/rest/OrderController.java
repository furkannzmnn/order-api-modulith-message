package org.furkan.order.infra.rest;

import org.furkan.order.domain.order.Order;
import org.furkan.order.dto.OrderCreateRequest;
import org.furkan.order.dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.craftgate.modulith.messaging.api.MessagePublisher.publishAndGet;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        Order order = publishAndGet(orderCreateRequest.toUseCase());
        return ResponseEntity.ok(OrderResponse.from(order));
    }
}
