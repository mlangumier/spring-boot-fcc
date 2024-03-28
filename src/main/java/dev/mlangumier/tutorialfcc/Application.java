package dev.mlangumier.tutorialfcc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.mlangumier.tutorialfcc.workout.Location;
import dev.mlangumier.tutorialfcc.workout.Workout;

@SpringBootApplication
public class Application {

	/**
	 * Will allow us to write a message when the server reloads
	 */
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	/**
	 * Main application function
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Get test info on our classes (ex: Workout)
	 * @return
	 */
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Workout workout = new Workout(1, "Box training", LocalDateTime.now().minus(1, ChronoUnit.HOURS), LocalDateTime.now(), 3, Location.GYM);
			log.info("Workout: " + workout);
		};
	}

}
