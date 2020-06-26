package com.oracle.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo {
	@Autowired
	Person per;
	@RequestMapping("")
    public String index(){
		System.out.println(per);
    	return "hello SpringBoot Demo";
    }
	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
		
     
	}

}
