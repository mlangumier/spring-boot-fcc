package dev.mlangumier.tutorialfcc.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);

        if(existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }


    // Let's store some runs
    @PostConstruct
    private void init() {
        runs.add(new Run(
            0, "Monday morning run", LocalDateTime.now().minus(20, ChronoUnit.MINUTES), LocalDateTime.now(), 3, Location.OUTDOOR
        ));
        runs.add(new Run(
            1, "Wednesday afternoon run", LocalDateTime.now().minus(45, ChronoUnit.MINUTES), LocalDateTime.now(), 5, Location.GYM
        ));
    }

}