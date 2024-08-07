package com.example.auditing.client.impl;

import com.example.auditing.advice.ApiResponse;
import com.example.auditing.client.EmployeeClient;
import com.example.auditing.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        try {

            ApiResponse<List<EmployeeDto>> employeeList = restClient.get()
                    .uri("/employee/findAllEmployee")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        System.out.println("Client error");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeList.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
