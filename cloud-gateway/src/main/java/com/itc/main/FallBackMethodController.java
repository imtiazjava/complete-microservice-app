package com.itc.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	
	@GetMapping("/empServiceFallBackMethod")
	public String employeeServiceFallBackMethod() {
		return "Employee Service is taking longer time: Please try again later";
		
	}
	
	@GetMapping("/dempServiceFallBackMethod")
	public String departmentServiceFallBackMethod() {
		return "Department Service is taking longer time: Please try again later";
		
	}
}
