package com.example.login_backend.Service;

import com.example.login_backend.DTO.UserLogin;
import com.example.login_backend.Model.UserRegister;
import com.example.login_backend.Repository.UserRepository;
import com.example.login_backend.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    public MessageResponse authenticateUser(UserLogin userLogin) {
        UserRegister user = userRepository.findByEmail(userLogin.getEmail());

        if (user != null) {
            // Perform password verification
            if (userLogin.getPassword().equals(user.getPassword())) {
                return new MessageResponse("Login successfully !!");
            }else {
                return new MessageResponse("Password is not correct !!");
            }
        }

        return new MessageResponse("Email is not exist !!");
    }
}
