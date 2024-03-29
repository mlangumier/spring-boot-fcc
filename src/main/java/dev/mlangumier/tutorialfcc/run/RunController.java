package dev.mlangumier.tutorialfcc.run;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/runs") // Defines the base of URL for this controller
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    public List<Run> findAll() {
        return runRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Run findbyId(@PathVariable Integer id) {
        Optional<Run> run =  runRepository.findById(id);

        if(run.isEmpty()) {
            throw new RunNotFoundException(); // Custom error
        }
        
        return run.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // 201: creation successfull
    // @Valid: uses "spring-boot-starter-validation" to check if data is ok, then throws or continues
    public void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // No content to send back, but not a 200
    public void update(@Valid @PathVariable Integer id, @RequestBody Run run) {
        runRepository.update(run,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}