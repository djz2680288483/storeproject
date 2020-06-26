package com.oracle.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	/*
	 * 
	 * */
	@Autowired
	DataSource datasource;
	@RequestMapping("/hello")
	@ResponseBody
	public String demo(){
		System.out.println(datasource);
		try {
			Connection conn=datasource.getConnection();
			System.out.println(conn);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello";
	}
	@Autowired
	JdbcTemplate jdbcTemplate;
	@RequestMapping("/getall")
	@ResponseBody
	public Map<String,Object> getAll(){
		String sql="select * from department";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list.get(0);
	}

}
