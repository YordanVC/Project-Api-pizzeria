package com.yordan.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class YordanPizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YordanPizzeriaApplication.class, args);
	}

}
