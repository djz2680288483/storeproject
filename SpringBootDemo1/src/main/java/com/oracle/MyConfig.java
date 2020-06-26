package com.oracle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.service.HelloService;
/*
 * @Configuration :指明当前类是一个配置类,配置类就相当于配置文件
 * 
 * */
@Configuration
public class MyConfig {
	//使用@Bean注来表明当前方法的返回值会被添加到spring的IOC容器中
	//添加到IOC容器的组件的默认 id：就是方法名 
	@Bean
   public HelloService helloService(){
	   
	   return new HelloService();
   }
}
