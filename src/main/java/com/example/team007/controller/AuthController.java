package com.example.team007.controller;



import com.example.team007.config.TokenListener;
import com.example.team007.dto.ResponseDto;
import com.example.team007.dto.RoleDto;
import com.example.team007.dto.UserDto;
import com.example.team007.models.LoginRequest;
import com.example.team007.models.Role;
import com.example.team007.models.UserEntity;
import com.example.team007.service.AuthService;
import com.example.team007.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private final TokenListener tokenListener;
    private final ObjectMapper objectMapper;

    @PostMapping("/login")
    public ResponseEntity<RoleDto> login(@RequestBody String request) throws JsonProcessingException {
        LoginRequest loginRequest = objectMapper.readValue(request, LoginRequest.class);
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1l);
        List<Role> roleList = userService.findByEmail(loginRequest.getEmail()).get().getRole();
        List<String> roles = new ArrayList<>();
        for (Role role : roleList
        ) {
            roles.add(role.name());
        }
        roleDto.setRoles(roles);
        roleDto.setToken(authService.loginResponse(loginRequest.getEmail(), loginRequest.getPassword()));
        return ResponseEntity.ok(roleDto);
    }


    @PostMapping("/register")
    public ResponseDto register(@RequestBody String register) throws JsonProcessingException {
        UserDto userDto = objectMapper.readValue(register, UserDto.class);
        UserEntity userEntity = objectMapper.convertValue(userDto, UserEntity.class);
        if (!userEntity.getEmail().contains("@")) {
            return ResponseDto.builder().status("emailinizi duzgun daxil edin").build();
        } else {
            List<Role> roleList = new ArrayList<>();
            if (userEntity.getEmail().startsWith("doctor")) {
                roleList.add(Role.ROLE_SUPERVISOR);
                roleList.add(Role.ROLE_ADMIN);
            } else if (userEntity.getEmail().startsWith("assistant")) {
                roleList.add(Role.ROLE_ADMIN);
            } else {
                roleList.add(Role.ROLE_USER);
            }
            userEntity.setRole(roleList);
        }
        userService.saveUser(userEntity);
        return ResponseDto.builder().id(1l).status("Ugurla Register oldunuz").build();
    }
}