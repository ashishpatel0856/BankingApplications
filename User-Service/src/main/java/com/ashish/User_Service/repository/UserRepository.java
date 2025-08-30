package com.ashish.User_Service.repository;

import com.ashish.User_Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

   Optional<User> findByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByAdharcardNumber(String adharcardNumber);
}
