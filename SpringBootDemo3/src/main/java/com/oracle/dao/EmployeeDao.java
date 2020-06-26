package com.oracle.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.entities.Department;
import com.oracle.entities.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "许飞", "aa@163.com", 1, new Department(101, "财务部")));
		employees.put(1002, new Employee(1002, "赵宇", "bb@163.com", 1, new Department(102, "营销部")));
		employees.put(1003, new Employee(1003, "李梅", "cc@163.com", 0, new Department(103, "开发部")));
		employees.put(1004, new Employee(1004, "朱欣", "dd@163.com", 0, new Department(104, "宣传部")));
		employees.put(1005, new Employee(1005, "马超", "ee@163.com", 1, new Department(101, "财务部")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
