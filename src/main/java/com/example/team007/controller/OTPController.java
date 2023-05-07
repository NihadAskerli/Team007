package com.example.team007.controller;

import com.example.team007.entity.Otp;
import com.example.team007.entity.OtpEmailDto;
import com.example.team007.entity.OtpVerifyDto;
import com.example.team007.repo.otpRepository;
import com.example.team007.util.EmailOTPUtil;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@Slf4j
@RequestMapping("/otp")
public class OTPController {

    private final EmailOTPUtil emailOTPUtil;
    private final com.example.team007.repo.otpRepository otpRepository;

    @Autowired
    public OTPController(EmailOTPUtil emailOTPUtil,
                         otpRepository otpRepository) {
        this.emailOTPUtil = emailOTPUtil;
        this.otpRepository = otpRepository;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOTP(@RequestBody OtpEmailDto dto) {
        String otp = emailOTPUtil.generateOTP();
        try {
            emailOTPUtil.sendOTPEmail(dto.getEmail(), otp);
            otpRepository.save(new Otp(null,otp, dto.getEmail()));
        } catch (MessagingException e) {
            log.error("exception",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP email.");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOTP(@RequestBody OtpVerifyDto requestBody) {
        String email = requestBody.getEmail();
        String otp = requestBody.getOtp();
        log.info(otpRepository.findByEmail(email)+"-");
        if (otp.equals(otpRepository.findByEmail(email).getOtp())) {
            return ResponseEntity.ok().body("Success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP.");
        }
    }
}