package com.example.login_backend.Controller;

import com.example.login_backend.DTO.UserLogin;
import com.example.login_backend.HandleException.ErrorResponse;
import com.example.login_backend.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserLoginController {

        @Autowired
    private UserLoginService userLoginService;
        @GetMapping("/")
        public ResponseEntity<UserLogin> login( String email, String password  ){
                UserLogin userLogin = userLoginService.signIn(email,password);
                if(userLogin == null){
                    throw new ErrorResponse("email or password  is not correct");
                }
                return new ResponseEntity<>(userLogin,HttpStatus.OK );
        }
}
