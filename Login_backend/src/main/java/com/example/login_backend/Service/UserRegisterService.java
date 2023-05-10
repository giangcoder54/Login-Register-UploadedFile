package com.example.login_backend.Service;

import com.example.login_backend.HandleException.ErrorResponse;
import com.example.login_backend.Model.UserRegister;
import com.example.login_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserRegisterService {
    @Autowired
    private UserRepository userRepository;



    public UserRegister createUser(UserRegister userRegister) {

        return userRepository.save(userRegister);


    }

    public UserRegister getUserById(Long id) {
        Optional<UserRegister> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


}
