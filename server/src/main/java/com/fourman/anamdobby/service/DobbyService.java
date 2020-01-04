package com.fourman.anamdobby.service;

import com.fourman.anamdobby.dto.DobbyResponseDto;
import com.fourman.anamdobby.model.Order;
import com.fourman.anamdobby.model.User;
import com.fourman.anamdobby.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DobbyService {
    private UserRepository userRepository;

    private OrderService orderService;

    public DobbyService(UserRepository userRepository, OrderService orderService) {
        this.userRepository = userRepository;
        this.orderService = orderService;
    }

    public List<DobbyResponseDto> findAllDobbys() {
        List<User> users = userRepository.findAll();
        List<DobbyResponseDto> dobbyResponseDtos = users.stream()
                .map(user -> user.toDobbyResponseDto())
                .collect(Collectors.toList());
        return dobbyResponseDtos;
    }

    public DobbyResponseDto findDobbyById(String naverId) {
        User user = userRepository.findUserByNaverId(naverId)
                .orElseThrow(() -> new RuntimeException(naverId + " id인 User를 찾지 못했습니다."));

        List<Order> ordersByDobby = orderService.findOrdersByDobby(naverId);
        double averageRate = ordersByDobby.stream()
                .mapToDouble(order -> order.getRate())
                .average()
                .orElse(0);

        return new DobbyResponseDto(user.getId(), user.getName(), user.getProfileFileName(), averageRate);
    }

    public List<String> findAllReviewById(String naverId) {
        List<Order> ordersByDobby = orderService.findOrdersByDobby(naverId);
        return ordersByDobby.stream()
                .map(order -> order.getReview())
                .collect(Collectors.toList());
    }
}
