package com.example.team007.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptorDto {

    private String name;
    private String surname;
    private Integer age;
    private Double salary;
    private String ownershipHome;
    private Double employeeTime;
    private String loanPruposes;
    private Double creditAmount;
    private Double loanRate;
}
