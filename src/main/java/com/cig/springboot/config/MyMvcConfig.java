package com.cig.springboot.config;

import com.cig.springboot.component.LoginHandlerInterceptor;
import com.cig.springboot.component.MyLocaleReolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurationSupport可以来扩展SpringMVC的功能
@Configuration
//不加@EnableWebMvc的时候是扩展springMvc的配置，也就是自己的配置和自动配置同时作用
//加了@EnableWebMvc的时候，会屏蔽自动配置，全面掌控springMvc配置
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	//   浏览器发送 /helloworld   请求到success
		registry.addViewController("/helloworld").setViewName("success");
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/main.html").setViewName("dashboard");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//静态资源；  *.css , *.js
		//SpringBoot已经做好了静态资源映射
		//registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/tologin","/*.js","*.css");
	}

	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocaleReolver();
	}


}
