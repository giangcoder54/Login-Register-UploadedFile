package com.example.login_backend.Repository;

import com.example.login_backend.DTO.UserLogin;
import com.example.login_backend.Model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserRepository extends JpaRepository<UserRegister,Long> {
  UserRegister findByEmail(String email);





}
