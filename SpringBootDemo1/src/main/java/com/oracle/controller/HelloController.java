package com.oracle.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.Person;
//@ImportResource(locations={"classpath:beans.xml"})
@RestController
public class HelloController {
	
	Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	Person per;
	@Autowired
	ApplicationContext app;
    @RequestMapping("/hello")
	 public String hello(){
		System.out.println("service是否存在："+app.containsBean("helloService"));
		 return "Hello SpringBoot"+per;
	  }
    @RequestMapping("/testDemo")
    @ResponseBody
    public String testDemo(){
    	logger.trace("这个是trace级别的日志");
    	logger.debug("这个是debug级别的日志");
    	logger.info("这个是info级别的日志");
    	logger.warn("这个是warn级别的日志");
    	logger.error("这个是error级别的日志");
    	return "hello";
    }
	
}
