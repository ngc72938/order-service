package com.shop.orderservice.repository;

import com.shop.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderKey(String orderKey);
    List<Order> findByUserId(String userId);
}
