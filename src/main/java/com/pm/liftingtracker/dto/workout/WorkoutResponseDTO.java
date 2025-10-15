package com.pm.liftingtracker.dto.workout;

import com.pm.liftingtracker.model.workout.Exercise;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
public class WorkoutResponseDTO {
    private String name;
    private List<ExerciseSetResponseDTO> exerciseSets;
    private String startTime;
    private String endTime;
}
