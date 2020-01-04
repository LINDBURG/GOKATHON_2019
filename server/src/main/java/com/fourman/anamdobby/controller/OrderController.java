package com.fourman.anamdobby.controller;

import com.fourman.anamdobby.dto.DobbyResponseDto;
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

    @GetMapping("/orders/{naverId}")
    ResponseEntity<Integer> getRoomStatus(@PathVariable String naverId) {
        return ResponseEntity.ok(orderService.getRoomStatus(naverId));
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

    @GetMapping("/orders/{naverId}/dobbys")
    ResponseEntity<List<DobbyResponseDto>> getDobbyCandidates(@PathVariable String naverId) {
        return ResponseEntity.ok(orderService.getDobbyCandidates(naverId));
    }

    @PostMapping("/orders/{naverId}/dobbys/{dobbyId}")
    ResponseEntity selectDobby(@PathVariable String naverId, @PathVariable long dobbyId) {
        orderService.selectDobby(naverId, dobbyId);
        return ResponseEntity.ok().build();
    }
}
