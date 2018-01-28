package com.javasampleapproach.jpamysqlangular4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class SpringJpaMySqlAngular4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaMySqlAngular4Application.class, args);
	}
}
