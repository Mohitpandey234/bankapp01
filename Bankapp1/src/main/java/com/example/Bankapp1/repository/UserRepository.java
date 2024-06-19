package com.example.Bankapp1.repository;

import com.example.Bankapp1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

Boolean existByEmail(String email);



}
