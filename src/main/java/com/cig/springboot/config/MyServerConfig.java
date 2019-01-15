package com.cig.springboot.config;

import com.cig.springboot.filter.MyFilter;
import com.cig.springboot.listener.MyListener;
import com.cig.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig{

	//配置嵌入式的servlet容器
	@Bean
	public WebServerFactoryCustomizer webServerFactoryCustomizer() {
	return 	new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
			//定制嵌入式的servlet容器相关的规则
			@Override
			public void customize(ConfigurableServletWebServerFactory server) {
				server.setPort(8083);
			}
		};
	}

	//注册三大组件
 	@Bean
	public ServletRegistrationBean myServlet(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean myFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean myListener(){
		ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
		return registrationBean;
	}
}
