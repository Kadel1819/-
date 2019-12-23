package com.kuwo.lmusic;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

/**在持久层接口添加了@Mapper,在编译后会生成相应的接口实现类*/
@MapperScan("com.kuwo.lmusic.mapper")/**加了这个注解就表示SprintBoot框架回去加载mapper持久成的接口的bean*/
@SpringBootApplication
@Configuration
public class LmusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmusicApplication.class, args);
	}
	@Bean
	public MultipartConfigElement a() {
		MultipartConfigElement element;
		MultipartConfigFactory factory = new MultipartConfigFactory();
		
		factory.setMaxFileSize(DataSize.ofMegabytes(100));
		factory.setMaxRequestSize(DataSize.ofMegabytes(100));
		
		return factory.createMultipartConfig();
	}
}
