package com.oracle.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.dao.EmployeeDao;
import com.oracle.entities.Employee;

@Controller
public class EmpController {

	@Autowired
	EmployeeDao employeeDao;
	@GetMapping(value="/emps")
	public String emps(Model model){
		Collection<Employee> emps = employeeDao.getAll();
		model.addAttribute("emps", emps);
		return "emp/list";
	}
}
