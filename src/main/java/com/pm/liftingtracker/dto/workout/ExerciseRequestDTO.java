package com.pm.liftingtracker.dto.workout;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseRequestDTO {

    @NotEmpty(message = "Please provide the name of the exercise")
    @Size(max = 100, message = "The exercise name cannot exceed 100 characters")
    private String name;

    @NotEmpty(message = "Please provide the description of the exercise")
    @Size(max = 500, message = "The exercise description cannot exceed 500 characters")
    private String description;

}
