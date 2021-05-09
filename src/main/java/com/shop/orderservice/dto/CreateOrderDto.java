package com.shop.orderservice.dto;

import lombok.Data;

@Data
public class CreateOrderDto {
    private String orderKey;

    private String productId;

    private Integer quantity;

    private Integer unitPrice;

    private Integer totalPrice;

    private String userId;
}
