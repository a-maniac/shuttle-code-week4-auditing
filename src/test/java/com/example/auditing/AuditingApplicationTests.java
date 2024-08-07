package com.example.auditing;

import com.example.auditing.client.EmployeeClient;
import com.example.auditing.client.impl.EmployeeClientImpl;
import org.hibernate.envers.Audited;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuditingApplicationTests {

	@Autowired
	EmployeeClientImpl employeeClient;

	@Test
	public void EmployeeClientTest(){
		employeeClient.getAllEmployee();
	}

}
