package com.example.login_backend.Service;

import com.example.login_backend.DTO.UserLogin;
import com.example.login_backend.Model.UserRegister;
import com.example.login_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    public UserLogin signIn(UserLogin userLogin){
        return null;
    }
}
