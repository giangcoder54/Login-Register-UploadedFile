package com.example.login_backend.Model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;

    private String username;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private FileDB image;

    public User() {

    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FileDB getImage() {
        return image;
    }

    public void setImage(FileDB image) {
        this.image = image;
    }
}
