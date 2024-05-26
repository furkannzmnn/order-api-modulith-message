package org.furkan.order.domain.order.notify;

import io.craftgate.modulith.messaging.api.annotation.MessageHandlerConfig;
import io.craftgate.modulith.messaging.api.handler.VoidMessageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@MessageHandlerConfig(selector = OrderCreateNotifyEvent.class, isTransactional = true)
public class CreateEventNotifiedHandler extends VoidMessageHandler<OrderCreateNotifyEvent> {

    private final OrderEventPublishPort orderEventPublishPort;

    @Override
    protected void handle(OrderCreateNotifyEvent message) {
        log.info("Order created event : {}", message.getTraceId());
        orderEventPublishPort.publish(message);
    }
}
