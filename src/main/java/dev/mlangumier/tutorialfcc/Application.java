package dev.mlangumier.tutorialfcc;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.mlangumier.tutorialfcc.run.RunRepository;
import dev.mlangumier.tutorialfcc.user.User;
import dev.mlangumier.tutorialfcc.user.UserHttpClient;
import dev.mlangumier.tutorialfcc.user.UserRestClient;
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

	/*
	 * Boilerplate allowing us to use the functions in the "/user/UserHttpClient.java" file without much code
	 */
	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}

	/**
	 * Allows us to test our data
	 */
	@Bean
	CommandLineRunner runner(RunRepository runRepository, UserHttpClient client) {
		return args -> {
			// Tests Run
			// Run run = new Run(1, "Box training", LocalDateTime.now().minus(1, ChronoUnit.HOURS), LocalDateTime.now(), 3, Location.GYM);
			// log.info("----- Run: " + run); // Allows us to check some data
			// runRepository.create(run); // Will create our data when the server starts

			// Tests User
			// List<User> users = client.findAll();
			// log.info("----- Users: " + users);
			// User user = client.findById(1);
			// log.info("----- User: " + user);
		};
	}
}
