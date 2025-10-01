package com.pm.liftingtracker.dto.workout;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExerciseSetRequestDTO {

    @NotNull
    private Integer exerciseId;

    @NotNull
    private Integer WorkoutId;

    @NotNull
    @Positive(message = "Exercise Load must be a positive number")
    private Double load;

    @NotNull
    @Positive(message = "Rep count must be a positive number")
    private Integer repetitions;
}
