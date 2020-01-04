package com.fourman.anamdobby.repository;

import com.fourman.anamdobby.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNaverId(String naverId);
}
