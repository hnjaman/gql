package com.demo.grql;

import com.demo.grql.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudGraphQlApplication.class, args);
	}
}
