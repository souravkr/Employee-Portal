package com.trickspy.thymeleafsecond.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trickspy.thymeleafsecond.dao.EmployeeRepository;
import com.trickspy.thymeleafsecond.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository dao;

	@Override
	public List<Employee> getEmp() {
		return dao.findAllByOrderByFirstName();
	}

	@Override
	public Employee findById(int id) {
		
		Employee emp = null;
		
		Optional<Employee> optEmp = dao.findById(id);
		if(optEmp.isPresent()) 
		{
			emp = optEmp.get();
		}
		
		return emp;
	}

	@Override
	public void save(Employee emp) {
		dao.save(emp);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
          dao.deleteById(id);
	}

}
