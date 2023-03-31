package com.example.login_backend.Service;

import com.example.login_backend.Model.FileDB;
import com.example.login_backend.Model.User;
import com.example.login_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
       return userRepository.save(user);
    }
    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }
    public FileDB uploadFile(Long userId, MultipartFile multipartFile){
            User user = getUserById(userId);
            FileDB fileDB = new FileDB();

            fileDB.setName(multipartFile.getOriginalFilename());
            fileDB.setType(multipartFile.getContentType());
        try {
            fileDB.setData(multipartFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            fileDB.setUser(user);
            user.setImage(fileDB);

            return fileDB;
    }
    public FileDB getFileByUserId(Long userId) {
        User user = getUserById(userId);
        return user.getImage();
    }
}
