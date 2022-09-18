package com.trickspy.thymeleafsecond.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trickspy.thymeleafsecond.entity.Employee;
import com.trickspy.thymeleafsecond.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class MainController {
	
	@Autowired
	EmployeeService empService;

	@GetMapping("/home")
	public String showHome(Model model) {
		
		/*
		 * List<Employee> empList = new ArrayList<>();
		 * 
		 * empList.add(new Employee("sourav","kumar",1)); empList.add(new
		 * Employee("Rohan","Verma",2)); empList.add(new Employee("Rakesh","Yumu",3));
		 */
	 
	List<Employee> empList = empService.getEmp();
		
	 model.addAttribute("employees",empList); 
	 
		return "home";
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
	
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		
	   return "emp-form";
	
	}
	
	@PostMapping("/processForm")
	public String showForm(@ModelAttribute("employee") Employee emp){
		System.out.println("i am here");
		empService.save(emp);
			
		return "redirect:/employees/home";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(Model model, @RequestParam("employeeId") int id) {
		
		Employee emp = empService.findById(id);
		model.addAttribute("employee",emp);
		
		return "emp-form";
	}
	
	@GetMapping("/deleteForm")
	public String deleteEmp(@RequestParam("employeeId") int id) {
		
		 empService.deleteById(id);
		
		return "redirect:/employees/home";
	}
	
	
}
