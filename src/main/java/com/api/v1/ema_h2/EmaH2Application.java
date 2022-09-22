package com.api.v1.ema_h2;

import com.api.v1.ema_h2.model.Persona;
import com.api.v1.ema_h2.service.PersonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmaH2Application.class, args);
	}

	@Bean
    CommandLineRunner run(PersonaService PS) {
        return args -> {
            PS.guardar(new Persona(null,"1234","juan","85208520"));
			PS.guardar(new Persona(null,"1234","pedro","85208520"));
        };
    }
}
