package com.example.login_backend.Controller;

import com.example.login_backend.HandleException.ErrorResponse;
import com.example.login_backend.Model.UserRegister;
import com.example.login_backend.Service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
   private UserRegisterService userRegisterService;

    private static final String EMAIL_REGEX =
            "^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$";

    @PostMapping("/user")
    public ResponseEntity<UserRegister> createUser(@RequestBody UserRegister userRegister){
        if (!validateEmail(userRegister.getEmail())) {
            throw new ErrorResponse("Invalid Email");
        }
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

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();

    }
}
