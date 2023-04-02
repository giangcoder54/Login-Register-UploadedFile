package com.example.login_backend.Repository;


import com.example.login_backend.Model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDbRepository extends JpaRepository<FileDB,Long> {
}
