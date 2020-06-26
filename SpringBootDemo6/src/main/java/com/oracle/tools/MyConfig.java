package com.oracle.tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class MyConfig {
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource datasource(){
		
		return new DruidDataSource();
	}
	@Bean
	public ServletRegistrationBean stateViewsServlet(){
		ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String, String> initParams=new HashMap<String, String>();
		initParams.put("loginUsername","admin");
		initParams.put("loginPassword","123456");
		initParams.put("allow","");
		bean.setInitParameters(initParams);
		return bean;
		
	}
	@Bean
	public FilterRegistrationBean webstateFilter(){
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		Map<String, String> initparams=new HashMap<String, String>();
		initparams.put("exclusion",".js,*.css,/druid/*");
		bean.setInitParameters(initparams);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}

}
