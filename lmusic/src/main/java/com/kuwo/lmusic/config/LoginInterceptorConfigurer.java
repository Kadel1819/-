package com.kuwo.lmusic.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kuwo.lmusic.Interceptor.LoginInterceptor;


@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//创建拦截器对象
		HandlerInterceptor interceptor = new LoginInterceptor();
		//不拦截路径(白名单 , 不需要登录就可以访问的资源)
		List<String> patterns = new ArrayList<>();
		patterns.add("/bootstrap3/**");
		patterns.add("/css/**");
		patterns.add("/images/**");
		patterns.add("/js/**");
		patterns.add("/users/reg");
		patterns.add("/users/login");
		patterns.add("/districts/");
		patterns.add("/web/register.html");
		patterns.add("/web/login.html");
		patterns.add("/products/**");
		patterns.add("/web/index.html");
		patterns.add("/web/regSinger.html");
		patterns.add("/web/regAlbum.html");
		
		
		//添加注册拦截器(黑名单)
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
	}
	
}
