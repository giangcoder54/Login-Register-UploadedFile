package com.example.login_backend.Controller;

import com.example.login_backend.Model.FileDB;
import com.example.login_backend.Model.User;
import com.example.login_backend.Service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserController {
    @Autowired
   private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
     User createdUser =   userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }
    @PostMapping("/upload/{id}")
    public ResponseEntity<FileDB> uploadFile(@PathVariable("id") Long userId, @RequestParam("file")MultipartFile file) throws IOException {
           FileDB upFile =   userService.uploadFile(userId,file);
                return ResponseEntity.ok(upFile );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
