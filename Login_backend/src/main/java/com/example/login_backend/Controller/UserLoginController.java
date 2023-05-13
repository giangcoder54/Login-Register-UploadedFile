package com.example.login_backend.Controller;

import com.example.login_backend.DTO.UserLogin;
import com.example.login_backend.HandleException.ErrorResponse;
import com.example.login_backend.Response.MessageResponse;
import com.example.login_backend.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoginController {

        @Autowired
         private UserLoginService userLoginService;
        @PostMapping("/login")
        public ResponseEntity<MessageResponse> loginUser(@RequestBody UserLogin userLogin ){
            MessageResponse isAuthenticated = userLoginService.authenticateUser(userLogin);


              return ResponseEntity.ok(isAuthenticated);
        }
}
