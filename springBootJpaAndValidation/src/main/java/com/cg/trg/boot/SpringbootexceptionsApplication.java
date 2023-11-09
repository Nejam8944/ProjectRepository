package com.cg.trg.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootexceptionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootexceptionsApplication.class, args);
	}

	@Bean
	public Docket getDocket() {

	ApiInfo info= new ApiInfo(
			"spring boot application",
			"project for Training practice at capgemini november 2023",
			 "3.0",
			"free for every one",
			new Contact("Nejamuddin Ali","www.Nejam.com","nejamuddinali7@gmail.com"),
			"free licence",
			"www.capgemini.com");
			
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cg"))
				.build()
				.apiInfo(info);

	}
}
