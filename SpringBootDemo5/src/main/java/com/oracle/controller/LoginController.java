package com.oracle.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@PostMapping(value="/user/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Map<String, Object> maps,HttpSession session){
		if(username!=null&&!username.trim().equals("")&&password!=null&&password.equals("123456")){
			session.setAttribute("username", username);
			
			return "redirect:/main.html";
			
		}else{
			maps.put("msg", "用户名或密码不正确");
			return "index";
		}
		
	}
}
