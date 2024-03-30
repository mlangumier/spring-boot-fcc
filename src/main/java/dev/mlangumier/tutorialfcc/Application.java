package dev.mlangumier.tutorialfcc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		log.info("Application up and running!");
	}

	/**
	 * Get test info on our classes (ex: Run)
	 * @return
	 */
	// @Bean
	// CommandLineRunner runner(RunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(1, "Box training", LocalDateTime.now().minus(1, ChronoUnit.HOURS), LocalDateTime.now(), 3, Location.GYM);
			
	// 		log.info("Run: " + run); // Allows us to check some data

	// 		runRepository.create(run); // Will create our data when the server starts
	// 	};
	// }

}
