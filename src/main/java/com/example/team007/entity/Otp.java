package com.example.team007.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "otps")
@AllArgsConstructor
@NoArgsConstructor
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "otp")
    private String otp;
    @Column(name = "email")
    private String email;

}
