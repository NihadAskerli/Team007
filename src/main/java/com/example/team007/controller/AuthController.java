package com.example.team007.controller;


import com.example.team007.models.LoginRequest;
import com.example.team007.models.LoginResponse;
import com.example.team007.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


@PostMapping("/login")
public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
    return authService.loginResponse(loginRequest.getEmail(),loginRequest.getPassword());
}
    @GetMapping("/test")
    public String test() {
        return "token duzgun isledi";
    }



}
