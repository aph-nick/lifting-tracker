package com.pm.liftingtracker.dto.workout;

import com.pm.liftingtracker.model.workout.Exercise;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseSetResponseDTO {
    private Integer id;
    private Double load;
    private Integer repetitions;
    private ExerciseResponseDTO exercise;
}
