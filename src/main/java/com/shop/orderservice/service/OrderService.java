package com.shop.orderservice.service;

import com.shop.orderservice.dto.CreateOrderDto;
import com.shop.orderservice.dto.ResponseOrderDto;

import java.util.List;

public interface OrderService {
    ResponseOrderDto save(CreateOrderDto createOrderDto);
    ResponseOrderDto findByOrderKey(String orderKey);
    List<ResponseOrderDto> findByUserId(String userId);
    ResponseOrderDto cancelOrder(String orderKey);

}
