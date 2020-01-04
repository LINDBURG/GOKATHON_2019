package com.fourman.anamdobby;

import com.fourman.anamdobby.model.Order;
import com.fourman.anamdobby.model.OrderDetail;
import com.fourman.anamdobby.model.User;
import com.fourman.anamdobby.repository.OrderRepository;
import com.fourman.anamdobby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DummyDataLoader implements ApplicationRunner {
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    @Autowired
    public DummyDataLoader(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        User sean = new User("ss1511", "sean", "profile1.jpg");
        userRepository.save(sean);
        User jaemin = new User("jaeminim95", "jaemin", "profile2.jpg");
        userRepository.save(jaemin);
        User hanju = new User("hanjjm1994", "hanju", "profile3.jpg");
        userRepository.save(hanju);
        User jaeho = new User("monc2", "jaeho", "profile1.jpg");
        userRepository.save(jaeho);

        Order order_1 = new Order(sean, new OrderDetail("안암동 5가 123-7 101호", "잘부탁드립니다!", 5000, "설거지", "1234"));
        order_1.setDobby(jaemin);
        order_1.setRate(4.5);
        order_1.setStatus(OrderStatus.DONE);
        order_1.setReview("재민이는 훌륭한 도비에요!");
        orderRepository.save(order_1);

        Order order_2 = new Order(jaemin, new OrderDetail("안암동 7가 777-7 77호", "럭키세븐", 7777, "바닥 청소", "7777"));
        order_2.setDobby(jaeho);
        order_2.setRate(1.7);
        order_2.setReview("성실하지 않은 도비에요 :(");
        orderRepository.save(order_2);
    }
}
