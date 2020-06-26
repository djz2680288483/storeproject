package com.oracle.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.oracle.bean.Department;
@Mapper
public interface DepartmentMapper {
	@Select("select *from department where id=#{id}")
   public Department getDeptById(Integer id);
	@Delete("delete *from department where id=#{id}")
	public int deleteDept(Integer id);
	@Insert("insert into department(departmentName) values (#{departmentName})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public int insertDept(Department dept);
	@Update("update department set departmentName=#{departmentName} where id=#{id}")
	public int updateDept(Department  dept);
}
