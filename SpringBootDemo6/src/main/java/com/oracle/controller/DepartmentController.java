package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.bean.Department;
import com.oracle.dao.DepartmentMapper;

@Controller
public class DepartmentController {
	@Autowired
	 DepartmentMapper mapper;
	@GetMapping("/dept/{id}")
	@ResponseBody
	 public Department getDepartment(@PathVariable("id") Integer id){
		 
		 return mapper.getDeptById(id);
	 }
	 
	@GetMapping("/dept")
	@ResponseBody
	public String insertDepartment(Department dept){
		mapper.insertDept(dept);
		return dept.toString();
	}
	

}
