package com.bitworld.dscommerce.repositories;

import com.bitworld.dscommerce.entities.Order;
import com.bitworld.dscommerce.entities.OrderItem;
import com.bitworld.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
