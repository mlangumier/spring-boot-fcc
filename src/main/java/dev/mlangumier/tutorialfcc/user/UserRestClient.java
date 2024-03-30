package dev.mlangumier.tutorialfcc.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component // Allows us to use an instance of it later
public class UserRestClient {
    // Using a RestClient allows us to easily use methods without having to fully code them (already usable)
    private final RestClient restClient;
    
    public UserRestClient(RestClient.Builder builder) {
        this.restClient = builder
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build();
    }

    public List<User> findAll() {
        return restClient.get()
            .uri("/users")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {});
    }

    public User findById(Integer id) {
        return restClient.get()
            .uri("/users/{id}", id)
            .retrieve()
            .body(User.class);

    }
}
