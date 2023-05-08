package com.example.login_backend.Controller;

import com.example.login_backend.HandleException.ErrorResponse;
import com.example.login_backend.Model.UserRegister;
import com.example.login_backend.Service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
   private UserRegisterService userRegisterService;

    @PostMapping("/user")
    public ResponseEntity<UserRegister> createUser(@RequestBody UserRegister userRegister){
     UserRegister createdUserRegister =   userRegisterService.createUser(userRegister);

        return new ResponseEntity<>(createdUserRegister, HttpStatus.CREATED);

    }


    @GetMapping("/user/{id}")
    public ResponseEntity<UserRegister> getUserById(@PathVariable("id") Long userId){
        UserRegister userRegister = userRegisterService.getUserById(userId);
        if(userRegister == null){
         throw new ErrorResponse("do not have user with id + "+ userId);
        }


       return new ResponseEntity<>(userRegister,HttpStatus.OK);
    }
}
