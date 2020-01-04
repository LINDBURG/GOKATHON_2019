package com.fourman.anamdobby.controller;

import com.fourman.anamdobby.dto.OrderDetailDto;
import com.fourman.anamdobby.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders/{naverId}")
    ResponseEntity requestRoomCleaning(@PathVariable String naverId, @RequestBody OrderDetailDto orderDetailDto) {
        orderService.save(naverId, orderDetailDto);
        return ResponseEntity.ok().build();
    }
}
