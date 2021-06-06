package com.shop.orderservice.controller;

import com.shop.orderservice.dto.CreateOrderDto;
import com.shop.orderservice.dto.ResponseDto;
import com.shop.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/order-service")
public class OrderController {
    private final Environment environment;
    private final OrderService orderService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in Order Service on Port "+ environment.getProperty("local.server.port");
    }

    @PostMapping("/order")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        var responseOrderDto = orderService.save(createOrderDto);

        var responseDto = new ResponseDto("주문 성공", responseOrderDto).getResponseEntity();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<Map<String, Object>> getUserOrder(@PathVariable("userId") String userId) {
        var responseOrderList = orderService.findByUserId(userId);

        var responseDto = new ResponseDto("주문 조회 성공", responseOrderList).getResponseEntity();

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable("orderId") String orderId) {
        var responseOrder = orderService.findByOrderKey(orderId);

        var responseDto = new ResponseDto("주문 조회 성공", responseOrder).getResponseEntity();

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/order/{orderId}/cancel")
    public ResponseEntity<Map<String, Object>> cancelOrder(@PathVariable("orderId") String orderId) {
        //TODO 주문 취솔 로직작성
        var responseDto = new ResponseDto("","").getResponseEntity();

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }


}
