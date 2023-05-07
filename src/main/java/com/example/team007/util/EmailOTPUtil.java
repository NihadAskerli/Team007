package com.example.team007.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailOTPUtil {

  private final JavaMailSender javaMailSender;

  @Autowired
  public EmailOTPUtil(JavaMailSender javaMailSender) {
      this.javaMailSender = javaMailSender;
  }

  public String generateOTP() {
      int otpLength = 6;
      StringBuilder otp = new StringBuilder();
      for (int i = 0; i < otpLength; i++) {
          otp.append((int) (Math.random() * 10));
      }
      return otp.toString();
  }

  public void sendOTPEmail(String toEmail, String otp) throws jakarta.mail.MessagingException {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message);
      helper.setTo(toEmail);
      helper.setSubject("OTP Verification");
      helper.setText("Your OTP is: " + otp);
      javaMailSender.send(message);
  }
}