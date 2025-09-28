package com.pm.liftingtracker.dto.workout;

import lombok.Getter;

import java.util.List;

@Getter
public class WorkoutResponseDTO {
    private String name;
    private List<ExerciseResponseDTO> exercises;
}
