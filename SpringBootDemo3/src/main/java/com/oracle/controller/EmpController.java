package com.oracle.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.oracle.dao.DepartmentDao;
import com.oracle.dao.EmployeeDao;
import com.oracle.entities.Department;
import com.oracle.entities.Employee;

@Controller
public class EmpController {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;
	@GetMapping(value="/emps")
	public String emps(Model model){
		Collection<Employee> emps = employeeDao.getAll();
		model.addAttribute("emps", emps);
		return "emp/list";
	}
	@GetMapping(value="/emp")
	public String toAddPage(Model model){
		Collection<Department> depts=departmentDao.getDepartments();
		model.addAttribute("depts",depts);
		return "emp/add";
	}
	@PostMapping(value= "/emp")
	public String addEmp(Employee employee){
		
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	@GetMapping(value="/emp/{id}")
	public String toChange(@PathVariable("id") Integer id,Model model){
		Employee emp=employeeDao.get(id);
		model.addAttribute("emp",emp);
		Collection<Department> depts=departmentDao.getDepartments();
		model.addAttribute("depts",depts);
		return "emp/add";
	}
	@PutMapping(value="/emp")
	public String updateEmp(HttpServletRequest request) throws ParseException{
		Employee employee=new Employee();
		employee.setId(Integer.parseInt(request.getParameter("id")));
		String birth=request.getParameter("birth");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		date=sdf.parse(birth);
		employee.setBirth(date);
		Department dep=new Department();
		dep.setId(Integer.parseInt(request.getParameter("department.id")));
		employee.setDepartment(dep);
		employee.setEmail(request.getParameter("email"));
		employee.setGender(Integer.parseInt(request.getParameter("gender"))  );
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	@DeleteMapping(value="/emp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
