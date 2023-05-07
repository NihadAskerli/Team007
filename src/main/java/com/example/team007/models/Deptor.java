package com.example.team007.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deptor {
    private String name;
    private String surname;
    private Integer age;
    private Double salary;
    private String ownershipHome;
    private String loanPruposes;
    private Double employeeTime;
    private Double creditAmount;
    private Double loanRate;

}
