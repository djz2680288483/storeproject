package com.oracle.controller;


import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
	@RequestMapping("/testdemo")
	public String hello(){
		
		return "hello";
	}
	@RequestMapping("/success")
	public String success(Map<String,Object> map){
		map.put("hello","你好");
		map.put("name","<h1>张三</h1>");
		map.put("users",Arrays.asList("zs","ls","wangwu"));
		return "success";
	}
	//@RequestMapping({"/","index.html"})
	//public String index(){
		
	//  return "index";
	//}

}
