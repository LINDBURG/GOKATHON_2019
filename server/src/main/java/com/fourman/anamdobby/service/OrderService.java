package com.fourman.anamdobby.service;

import com.fourman.anamdobby.dto.DobbyResponseDto;
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
        List<Order> orders = orderRepository.findOrderByAuthor(user).stream()
                .sorted((order1, order2) -> (int) (order2.getId() - order1.getId())) // 나의 order 중 가장 최근의(ID가 큰) order 반환
                .collect(Collectors.toList());
        return orders.get(0).getStatus().getStatusNumber();
    }

    public void selectDobby(String naverId, long dobbyId) {
        User author = userService.findUserByNaverId(naverId);
        User dobby = userService.findUserById(dobbyId);

        Order order = orderRepository.findOrderByAuthor(author).stream()
                .filter(order1 -> order1.isNotFinished())
                .findAny()
                .orElseThrow(() -> new RuntimeException(author.getName() + " 이름의 집 청소 요청이 존재하지 않습니다."));
        order.setDobby(dobby);
    }

    public List<DobbyResponseDto> getDobbyCandidates(String naverId) {
        User author = userService.findUserByNaverId(naverId);
        Order order = orderRepository.findOrderByAuthor(author).stream()
                .sorted((order1, order2) -> (int) (order2.getId() - order1.getId()))
                .collect(Collectors.toList()).get(0);
        return userService.findAllDobbyByOrder(order);
    }

    public Order findOrderById(long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException(orderId + " id인 Order를 찾지 못하였습니다."));
    }
}
