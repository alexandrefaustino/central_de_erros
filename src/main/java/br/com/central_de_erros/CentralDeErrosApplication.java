package br.com.central_de_erros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class CentralDeErrosApplication {

	private static final String ALL = "*";

	public static void main(String[] args) {
		SpringApplication.run(CentralDeErrosApplication.class, args);
	}

//	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins(ALL)
						.allowedHeaders(ALL)
						.allowedMethods(ALL);
			}
		};
	}
}
