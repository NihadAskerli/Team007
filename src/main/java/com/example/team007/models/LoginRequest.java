package com.example.team007.models;

import lombok.*;

@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
