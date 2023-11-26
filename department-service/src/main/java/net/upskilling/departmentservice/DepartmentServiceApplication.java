package net.upskilling.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
		info=@Info(
				 title= "Springboot Rest API Documentation",
				 description="swagger",
				 version="v1.0",
				 contact = @Contact(
							name = "Ritika",
							email = "javaguides.net@gmail.com",
							url = "https://www.javaguides.net"
					),
					license = @License(
							name = "Apache 2.0",
							url = "https://www.javaguides.net/license"
					)
			),
				externalDocs = @ExternalDocumentation(
						description = "Spring Boot Department Service Documentation",
						url = "https://www.javaguides.net/user_management.html"
				 
		)
		)

public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
