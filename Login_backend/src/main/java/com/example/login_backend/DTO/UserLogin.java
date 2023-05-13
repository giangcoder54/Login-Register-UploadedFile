package com.example.login_backend.DTO;

public class UserLogin {

    private String password;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserLogin( String email,String password) {
        this.password = password;
        this.email = email;
    }
}
