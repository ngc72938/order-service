package com.shop.orderservice.service;

import com.shop.orderservice.dto.CreateOrderDto;
import com.shop.orderservice.dto.ResponseOrderDto;
import com.shop.orderservice.entity.Order;
import com.shop.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;

    @Override
    public ResponseOrderDto save(CreateOrderDto createOrderDto) {
        var order = modelMapper.map(createOrderDto, Order.class);

        order.setOrderKey(UUID.randomUUID().toString());
        order.setTotalPrice(createOrderDto.getUnitPrice() * createOrderDto.getQuantity());
        orderRepository.save(order);

        return modelMapper.map(order, ResponseOrderDto.class);
    }

    @Override
    public ResponseOrderDto findByOrderKey(String orderKey) {
        var order = orderRepository.findByOrderKey(orderKey).orElseGet(Order::new);
        if(order.getId() == 0)
            throw new NoSuchElementException("일치하는 주문이 존재 하지 않습니다.");

        return modelMapper.map(order, ResponseOrderDto.class);
    }

    @Override
    public List<ResponseOrderDto> findByUserId(String userId) {
        var orderList = orderRepository.findByUserId(userId);
        var responseOrderList = new ArrayList<ResponseOrderDto>();

        orderList.forEach(order ->
            responseOrderList.add(
                modelMapper.map(order, ResponseOrderDto.class)
            )
        );

        return responseOrderList;
    }
}
