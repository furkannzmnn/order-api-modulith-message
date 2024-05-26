package org.furkan.order.infra.jpa;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import lombok.RequiredArgsConstructor;
import org.furkan.order.domain.order.Order;
import org.furkan.order.domain.order.OrderPort;

@DomainComponent
@RequiredArgsConstructor
public class OrderDataAdapter implements OrderPort {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public void save(Order orderEntity) {
        orderJpaRepository.save(OrderEntity.fromModel(orderEntity));
    }

    @Override
    public Order findById(Long id) {
        return orderJpaRepository.findById(id)
                .map(OrderEntity::toModel)
                .orElse(null);
    }

    @Override
    public void deleteAll() {
        orderJpaRepository.deleteAll();
    }
}
