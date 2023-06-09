package com.example.team007.repo;

import com.example.team007.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
     Optional<UserEntity> findByEmail(String email);
}
