package com.example.team007.repo;

import com.example.team007.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface otpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmail(String email);
}
