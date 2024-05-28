package com.atividaden2.desafiopicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

// TODO: Auto-generated Javadoc
/**
 * The Class DesafiopicpayApplication.
 */
@EnableJdbcAuditing
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
	    title = "Desafio PicPay",
	    version = "1.0",
	    description = "Trabalho Prático para Avaliação N2",
	    license = @License(name = "Open Source")
	))
public class DesafiopicpayApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DesafiopicpayApplication.class, args);
	}

}
