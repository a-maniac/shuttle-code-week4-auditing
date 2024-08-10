package com.example.auditing.client.impl;

import com.example.auditing.advice.ApiResponse;
import com.example.auditing.client.EmployeeClient;
import com.example.auditing.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    Logger log= LoggerFactory.getLogger(EmployeeClientImpl.class);

    private final RestClient restClient;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        try {
            log.trace("Attempting to get All employees");

            ApiResponse<List<EmployeeDto>> employeeList = restClient.get()
                    .uri("/employee/findAllEmployee")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error("Client error");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            //use .toEntity if we want Api Response
            return employeeList.getData();
        } catch (Exception e) {
            log.error("Error:{}",e);
            throw new RuntimeException(e);
        }

    }
}
