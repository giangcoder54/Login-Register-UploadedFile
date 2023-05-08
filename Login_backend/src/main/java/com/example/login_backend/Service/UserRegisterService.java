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

    private static final String EMAIL_REGEX =
            "^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$";

    public UserRegister createUser(UserRegister userRegister) {
        if (!validateEmail(userRegister.getEmail())) {
           throw new ErrorResponse("Invalid Email");
        }
        return userRepository.save(userRegister);


    }

    public UserRegister getUserById(Long id) {
        Optional<UserRegister> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();

    }
}
