package com.example.login_backend.Repository;

import com.example.login_backend.Model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegister,Long> {


}
