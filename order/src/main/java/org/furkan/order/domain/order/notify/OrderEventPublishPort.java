package org.furkan.order.domain.order.notify;

import org.furkan.order.domain.EventPublisher;

public interface OrderEventPublishPort extends EventPublisher<OrderCreateNotifyEvent> {
    void publish(OrderCreateNotifyEvent orderCreateNotifyEvent);
}
