package org.furkan.order.domain.order;

public interface OrderPort {

    void save(Order orderEntity);
    Order findById(Long id);
    void deleteAll();
}
