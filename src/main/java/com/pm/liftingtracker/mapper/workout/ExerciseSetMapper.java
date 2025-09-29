package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.ExerciseSetResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.ExerciseSet;

public class ExerciseSetMapper implements Mapper<ExerciseSetResponseDTO, ExerciseSet> {
    @Override
    public ExerciseSetResponseDTO toDto(ExerciseSet exerciseSet) {
        return null;
    }

    @Override
    public ExerciseSet toModel(ExerciseSetResponseDTO exerciseSetResponseDTO) {
        return null;
    }
}
