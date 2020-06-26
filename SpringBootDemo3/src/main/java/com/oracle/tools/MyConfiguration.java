package com.oracle.tools;
//自定义配置类
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//当我们发送访问项目根目录的请求的时候，我们让他访问index.html
		registry.addViewController("/").setViewName("index");
		//当我们发送访问项目中的index.html请求的时候，我们让他访问index.html
		registry.addViewController("/index.html").setViewName("index");
		registry.addViewController("/main.html").setViewName("dashboard");
	}
	/**
	 * 我们想要让国际化生效，我们需要向IOC容器中注入一个LocalResolver
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocalResolver();
	}
	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInteraptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login");
	}
}
