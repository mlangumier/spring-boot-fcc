package dev.mlangumier.tutorialfcc.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

// Because it's a "record", this class is immutable (no getter or setter);
public record Run (
    @Id
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    Integer miles,
    Location location,
    @Version
    Integer version
) {
    // Can use 'spring-boot-starter-validation' to define fields in the class (ex: @NotEmpty)

    // Or can verify data manually:
    public Run {
        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("'Completed On' must be after 'Started On'");
        }
    }
}