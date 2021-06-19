package com.shop.orderservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
@DynamicUpdate
public class Order extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false, length = 120)
    private String productId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, unique = true)
    private String orderKey;

    private boolean isCanceled;
}
