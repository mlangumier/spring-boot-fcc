package dev.mlangumier.tutorialfcc.workout;

import java.time.LocalDateTime;

// Because it's a "record", this class is immutable (to getter or setter);

public record Workout (
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location
) {}