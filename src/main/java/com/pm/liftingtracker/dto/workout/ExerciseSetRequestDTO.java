package com.pm.liftingtracker.dto.workout;

import com.pm.liftingtracker.model.workout.Exercise;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ExerciseSetRequestDTO {

    @NotNull
    @Positive(message = "Exercise Load must be a positive number")
    @Setter
    private Double load;

    @NotNull
    @Positive(message = "Rep count must be a positive number")
    @Setter
    private Integer repetitions;

    @NotNull(message = "Exercise ID is required")
    private Integer exerciseId;
}
