package com.pm.liftingtracker.dto.workout;

import com.pm.liftingtracker.model.workout.Exercise;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutResponseDTO {
    private String name;
    private List<ExerciseResponseDTO> exercises;
}
