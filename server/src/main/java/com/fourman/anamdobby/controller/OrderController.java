package com.fourman.anamdobby.controller;

import com.fourman.anamdobby.dto.OrderDetailDto;
import com.fourman.anamdobby.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/orders")
    ResponseEntity<List<OrderDetailDto>> getOrderListToClean() {
        return ResponseEntity.ok(orderService.findAllOrderDetailDtos());
    }

    @GetMapping("/orders/{naverId}")
    ResponseEntity<Integer> getRoomStatus(@PathVariable String naverId) {
        return ResponseEntity.ok(orderService.getRoomStatus(naverId));
    }
}
