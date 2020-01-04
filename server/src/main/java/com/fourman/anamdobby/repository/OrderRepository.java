package com.fourman.anamdobby.repository;

import com.fourman.anamdobby.model.Order;
import com.fourman.anamdobby.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByDobby(User dobby);
    List<Order> findOrderByAuthor(User author);
}
