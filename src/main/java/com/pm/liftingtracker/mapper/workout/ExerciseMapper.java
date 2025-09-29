package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.ExerciseResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.Exercise;

public class ExerciseMapper implements Mapper<ExerciseResponseDTO, Exercise> {
    @Override
    public ExerciseResponseDTO toDto(Exercise exercise) {
        return null;
    }

    @Override
    public Exercise toModel(ExerciseResponseDTO exerciseResponseDTO) {
        return null;
    }
}
