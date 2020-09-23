package com.capg.otms.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
 //it is a combination of @configuration, @componentscan, @enableautoconfiguration
 //it will configure the bean class, starts component scan from base package
 //tomcat embbeded with ready to serve beans

public class ScreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenApplication.class, args);
	}

}
