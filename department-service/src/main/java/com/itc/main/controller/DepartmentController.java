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

import com.itc.main.entity.Department;
import com.itc.main.services.DepartmentService;

@RestController
@RequestMapping("/apidept/")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	
	@PostMapping("save")
	public ResponseEntity<Department> save(@RequestBody Department department)
	{
		Department d = this.departmentService.save(department);
		return new ResponseEntity<Department>(d, HttpStatus.CREATED);
	}
	
	@GetMapping("{departmentId}")
	public Department findDepartmentById(@PathVariable("departmentId") Long departmentId)
	{
		System.out.println("did:"+departmentId);
		return this.departmentService.findById(departmentId);
		
	}

}
