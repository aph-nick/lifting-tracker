package com.pm.liftingtracker.dto.workout;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutRequestDTO {

    @NotEmpty(message = "Please provide the workout name")
    @Size(max = 100, message = "The workout name cannot exceed 100 characters!")
    private String name;
}
