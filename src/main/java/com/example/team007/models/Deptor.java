package com.example.team007.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deptors")
public class Deptor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_assistants")
    @SequenceGenerator(
            name = "seq_assistants", allocationSize = 1
    )
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private Double salary;
    private String home_ownership;
    private String employment_time;
    private Double loan_purposes;
    private Double Credit_Amount;
    private Double loan_rate;
    private Double loan_percentage;

}
