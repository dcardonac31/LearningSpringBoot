package com.clientecontacto.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages= {"com.clientecontacto.controller, com.clientecontacto.inicio"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate template() {
		BasicAuthenticationInterceptor intercep;
		intercep=new BasicAuthenticationInterceptor("admin", "admin");
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(intercep);
		return template;
	}
}
