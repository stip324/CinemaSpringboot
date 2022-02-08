package com.movie.managment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan

@EnableAutoConfiguration

//@CrossOrigin("http://localhost:4200") 
public class ManagmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ManagmentApplication.class, args);
		
	}

}
