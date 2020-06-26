package com.oracle;

import java.util.Date;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value={"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix="person")
public class Person {
	//@Value("${person.name")
   private String name;
//	@Value("${person.age}")
   private int age;
	//@Value("${person.email}")
   private String email;
	//@Value("${person.birthDay}")
   private Date birthDay;
	
   private Map<String,Object> map;
	
   private Dog dog;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirthDay() {
	return birthDay;
}
public void setBirthDay(Date birthDay) {
	this.birthDay = birthDay;
}
public Map<String, Object> getMap() {
	return map;
}
public void setMap(Map<String, Object> map) {
	this.map = map;
}
public Dog getDog() {
	return dog;
}
public void setDog(Dog dog) {
	this.dog = dog;
}
@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", email=" + email + ", birthDay=" + birthDay + ", map=" + map
			+ ", dog=" + dog + "]";
}
   
   
}
