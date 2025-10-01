package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.ExerciseRequestDTO;
import com.pm.liftingtracker.dto.workout.ExerciseResponseDTO;
import com.pm.liftingtracker.model.workout.Exercise;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public ExerciseResponseDTO toDto(Exercise exercise) {
        ExerciseResponseDTO dto = new ExerciseResponseDTO();

        dto.setId(exercise.getId());
        dto.setName(exercise.getName());
        dto.setDescription(exercise.getDescription());

        return dto;
    }

    public Exercise toModel(ExerciseRequestDTO exerciseRequestDTO) {
        Exercise exercise = new Exercise();

        exercise.setName(exerciseRequestDTO.getName());
        exercise.setDescription(exerciseRequestDTO.getDescription());

        return exercise;
    }
}
