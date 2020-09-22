package com.capg.otms.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages= {"com.capg.otms.ms.model"})
public class ScreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenApplication.class, args);
	}

}
