package com.example.login_backend.Service;

import com.example.login_backend.DTO.UserLogin;
import com.example.login_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    public UserLogin signIn(String email, String password){
        UserLogin userLogin1 = userRepository.findEmailAndPassword(email );
        if(userLogin1 != null && userLogin1.getPassword() == password){
            return userLogin1;
        }
        return null;
    }
}
