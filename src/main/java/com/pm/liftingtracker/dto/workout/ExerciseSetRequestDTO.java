package com.pm.liftingtracker.dto.workout;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ExerciseSetRequestDTO {

    @NotNull
    @Positive(message = "Exercise Load must be a positive number")
    private Double load;

    @NotNull
    @Positive(message = "Rep count must be a positive number")
    private Integer repetitions;
}
