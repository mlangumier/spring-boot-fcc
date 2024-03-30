package dev.mlangumier.tutorialfcc.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


@Repository
public class JdbcClientRunRepository {
    // private List<Run> runs = new ArrayList<>();

    /**
     * In-Database methods
     * These methods are used with the database
     */

    private static final Logger log = LoggerFactory.getLogger(JdbcClientRunRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run")
            .query(Run.class)
            .list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM Run WHERE id = id")
            .param("id", id)
            .query(Run.class)
            .optional();
    }

    public void create(Run run) {
        var response = jdbcClient.sql("INSERT INTO Run(id, title, started_on, completed_on, miles, location) values(?,?,?,?,?,?)")
            .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
            .update();

        Assert.state(response == 1, "Failed to create run " + run.title());
    }

    public void update(Run run, Integer id) {
        var response = jdbcClient.sql("UPDATE Run SET title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? WHERE id = ?")
            .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
            .update();
        
        Assert.state(response == 1, "Failed to update run " +run.title());
    }


    public void delete(Integer id) {
        var response = jdbcClient.sql("DELETE FROM Run WHERE id = :id") 
            .param("id", id)
            .update();

        Assert.state(response == 1, "Failed to delete Run " + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT * FROM Run")
            .query().listOfRows().size();
    }

    // To create many entries at a time, we'll get an array and iterate on it with the create() function.
    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run>findByLocation(String location) {
        return jdbcClient.sql("SELECT * FROM Run WHERE location = :location")
            .param("location", location)
            .query(Run.class)
            .list();
    }

    /**
     * In-Memory methods
     * These methods are used before setting up the database, 
     * but still serve as examples of what can be done
     */

    // List<Run> findAll() {
    //     return runs;
    // }

    // Optional<Run> findById(Integer id) {
    //     return runs.stream().filter(run -> run.id() == id).findFirst();
    // }

    // void create(Run run) {
    //     runs.add(run);
    // }

    // void update(Run run, Integer id) {
    //     Optional<Run> existingRun = findById(id);

    //     if(existingRun.isPresent()) {
    //         runs.set(runs.indexOf(existingRun.get()), run);
    //     }
    // }

    // void delete(Integer id) {
    //     runs.removeIf(run -> run.id().equals(id));
    // }


    // // Let's store some runs
    // @PostConstruct
    // private void init() {
    //     runs.add(new Run(
    //         0, "Monday morning run", LocalDateTime.now().minus(20, ChronoUnit.MINUTES), LocalDateTime.now(), 3, Location.OUTDOOR
    //     ));
    //     runs.add(new Run(
    //         1, "Wednesday afternoon run", LocalDateTime.now().minus(45, ChronoUnit.MINUTES), LocalDateTime.now(), 5, Location.GYM
    //     ));
    // }

}