package com.example.team007.dto;

import com.example.team007.models.LoginResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private List<String> roles;
    private LoginResponse token;
}
