package com.fourman.anamdobby.service;

import com.fourman.anamdobby.dto.OrderDetailDto;
import com.fourman.anamdobby.model.Order;
import com.fourman.anamdobby.model.OrderDetail;
import com.fourman.anamdobby.model.User;
import com.fourman.anamdobby.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private OrderRepository orderRepository;

    private UserService userService;

    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public void save(String naverId, OrderDetailDto orderDetailDto) {
        User user = userService.findUserByNaverId(naverId);
        Order order = new Order(user, orderDetailDto.toEntity());
        orderRepository.save(order);
    }

    public List<Order> findOrdersByDobby(String naverId) {
        User dobby = userService.findUserByNaverId(naverId);
        return orderRepository.findAllByDobby(dobby);
    }

    public List<OrderDetailDto> findAllOrderDetailDtos() {
        return orderRepository.findAll().stream()
                .filter(Order::isNotStarted)
                .map(Order::getOrderDetail)
                .map(OrderDetail::toDto)
                .collect(Collectors.toList());
    }

    public Integer getRoomStatus(String naverId) {
        User user = userService.findUserByNaverId(naverId);
        Order order = orderRepository.findOrderByAuthor(user);
        return order.getStatus().getStatusNumber();
    }
}
