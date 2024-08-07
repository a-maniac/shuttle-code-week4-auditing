package com.example.auditing.client;

import com.example.auditing.dto.EmployeeDto;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDto> getAllEmployee();
}
