package com.hcmus.personalfinanceapiservice;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.hcmus.personalfinanceapicommon"})
public class PersonalFinanceApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApiServiceApplication.class, args);
	}

}
