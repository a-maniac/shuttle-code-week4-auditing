package com.example.auditing.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class EmployeeDto {

    private String name;
    private String email;
    private Long id;
    private Integer age;
    private String role; // ADMIN , USER
    private LocalDate dateOfJoining;
    private Boolean isActive;
    private Double salary;
    private String password;


    public EmployeeDto(){
        
    }

}
