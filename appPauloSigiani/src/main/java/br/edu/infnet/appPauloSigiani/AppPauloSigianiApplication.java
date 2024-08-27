package br.edu.infnet.appPauloSigiani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppPauloSigianiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPauloSigianiApplication.class, args);
	}

}
