package com.shop.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrderDto implements Serializable {
    private Long id;

    private String productId;

    private Integer quantity;

    private Integer unitPrice;

    private Integer totalPrice;

    private String userId;

    private String orderKey;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
