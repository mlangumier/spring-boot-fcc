package dev.mlangumier.tutorialfcc.run;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;


// We create an interface that extends ListCrudRepository(returns a list)<of type Run, for which the ID is an Integer)
// Now, many CRUD methods are available to us and auto-managed, modifying some of our methods in RunController .

public interface RunRepository extends ListCrudRepository<Run, Integer> {
    List<Run> findAllByLocation(String location);
}
