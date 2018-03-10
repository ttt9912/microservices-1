package com.zuehlke.microservices.uebung1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Uebung1Application {

	// startet Spring Container
	public static void main(String[] args) {
		SpringApplication.run(Uebung1Application.class, args);
	}

	/*
	 * Registrieren der Adapter als Bean, sodass Spring Instanzen davon erzeugen kann
	 * und mit ihnen den Controller erzeugen kann.
	 * Vorteil dieser Variante: Spring kennt die Adapter nicht. Daher könnten sie auch
	 * extern in einem anderen Maven Modul sein.
	 *
	 * Alternative: Adapter mit @Component annotieren und auf no-args Konstruktor umstellen
	 */


	@Bean
	public MovieServiceAdapter movieServiceAdapter(@Value("${endpoint.movie-service}") String url){
		return new MovieServiceAdapter(url);
	}

	@Bean
	public RatingAdapter ratingAdapter(@Value("${endpoint.movie-rating-service}") String url){
		return new RatingAdapter(url);
	}

}
