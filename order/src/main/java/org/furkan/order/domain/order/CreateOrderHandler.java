package org.furkan.order.domain.order;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import io.craftgate.modulith.messaging.api.annotation.MessageHandlerConfig;
import io.craftgate.modulith.messaging.api.handler.MessageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
@MessageHandlerConfig(selector = CreateOrderUseCase.class, isTransactional = true)
public class CreateOrderHandler extends MessageHandler<CreateOrderUseCase, Order> {

    private final OrderPort orderPort;

    public Order handle(CreateOrderUseCase message) {
        Order order = Order.create(message);
        orderPort.save(order);
        log.info("Order created: {}", order);
        order.publishMessages();
        return order;
    }

}
