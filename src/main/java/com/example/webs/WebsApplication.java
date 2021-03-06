package com.example.webs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("cn.example.*")
@Configuration
public class WebsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsApplication.class, args);
	}
}
