package com.ibero.arquitectura.calendario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CalendarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarioApplication.class, args);
	}

}
