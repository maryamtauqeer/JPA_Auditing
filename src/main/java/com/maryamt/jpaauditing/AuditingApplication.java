package com.maryamt.jpaauditing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AuditingApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuditingApplication.class, args);
		log.info("Spring boot and jpa auditing application :)");
	}

}
