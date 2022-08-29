package com.itc.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.Department;
import com.itc.main.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department save(Department department) {
		return this.departmentRepository.save(department);

	}

	public Department findById(Long departmentId) {
	
		Optional<Department> op=this.departmentRepository.findById(departmentId);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}

}
