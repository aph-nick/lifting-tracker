package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.ExerciseResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.Exercise;

public class ExerciseMapper implements Mapper<ExerciseResponseDTO, Exercise> {

    @Override
    public ExerciseResponseDTO toDto(Exercise exercise) {
        ExerciseResponseDTO dto = new ExerciseResponseDTO();

        dto.setId(exercise.getId());
        dto.setName(exercise.getName());
        dto.setDescription(exercise.getDescription());

        return dto;
    }

    @Override
    public Exercise toModel(ExerciseResponseDTO exerciseResponseDTO) {
        Exercise exercise = new Exercise();

        exercise.setId(exerciseResponseDTO.getId());
        exercise.setName(exerciseResponseDTO.getName());
        exercise.setDescription(exerciseResponseDTO.getDescription());
        exercise.setName(exerciseResponseDTO.getName());

        return exercise;
    }
}
