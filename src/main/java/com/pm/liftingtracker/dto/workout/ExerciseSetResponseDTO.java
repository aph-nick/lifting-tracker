package com.pm.liftingtracker.dto.workout;

import com.pm.liftingtracker.model.workout.Exercise;
import lombok.Getter;

@Getter
public class ExerciseSetResponseDTO {
    private Integer id;
    private Double load;
    private Integer repetitions;
    private Exercise exercise;
}
