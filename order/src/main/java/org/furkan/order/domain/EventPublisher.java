package org.furkan.order.domain;

public interface EventPublisher<T> {
    void publish(T event);
}
