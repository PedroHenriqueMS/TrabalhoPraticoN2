package com.atividaden2.desafiopicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class DesafiopicpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiopicpayApplication.class, args);
	}

}
