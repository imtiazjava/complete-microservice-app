package com.itc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itc.main.entity.Employee;
import com.itc.main.services.EmployeeService;
import com.itc.main.vo.Department;
import com.itc.main.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/apiemp/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee emp = this.employeeService.save(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("{employeeId}")
	public ResponseTemplateVO getEmployeeWithDepartmentDetails(@PathVariable Long employeeId)
	{
		   ResponseTemplateVO rt=new ResponseTemplateVO();
		   Employee emp = this.employeeService.findByEmployeeId(employeeId);
		   //Get the Department Details from another service
		   //In order to invoke other service use RestTemplate
		   //Department dept=this.restTemplate.getForObject("http://localhost:7771/apidept/"+emp.getDepartmentId(),Department.class);
		   	Department dept=this.restTemplate.getForObject("http://DEPATMENT-SERVICE/apidept/"+emp.getDepartmentId(),Department.class);
		   //Store Emp, Dept object into the ResponseTemplateVo and send back to the client
		   rt.setEmployee(emp);
		   rt.setDepartment(dept);
		   
		   return rt;
	}
}
