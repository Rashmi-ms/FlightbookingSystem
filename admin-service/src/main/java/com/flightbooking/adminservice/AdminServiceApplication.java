package com.flightbooking.adminservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.flightbooking.adminservice.service.AdminServiceImpl;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.flightbooking.adminservice.controller"})
@EnableEurekaClient
@EnableSwagger2
public class AdminServiceApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public  Docket swaggerConfiguration()  {
            return new Docket(DocumentationType.SWAGGER_2)  
                .select() 
                .apis(RequestHandlerSelectors.basePackage("com.flightbooking.adminservice.controller"))
                .paths(PathSelectors.any())                          
                .build()
                .apiInfo(apiDetails());
	}
    private ApiInfo apiDetails() {
	        return  new ApiInfo("AdminController Api",
			"Api Collections",
			null,
			null,
			new springfox.documentation.service.Contact(null, null, null),
			null,null,Collections.emptyList());
    }
			
	
	@Bean
	public AdminServiceImpl getAdminServiceImpl () {
		return new AdminServiceImpl();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}