package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.ExerciseSetResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.ExerciseSet;

public class ExerciseSetMapper implements Mapper<ExerciseSetResponseDTO, ExerciseSet> {

    private final ExerciseMapper exerciseMapper;

    public ExerciseSetMapper(ExerciseMapper exerciseMapper) {
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public ExerciseSetResponseDTO toDto(ExerciseSet exerciseSet) {
        ExerciseSetResponseDTO dto = new ExerciseSetResponseDTO();

        dto.setId(exerciseSet.getId());
        dto.setLoad(exerciseSet.getLoad());
        dto.setRepetitions(exerciseSet.getRepetitions());
        dto.setExercise(exerciseMapper.toDto(exerciseSet.getExercise()));

        return dto;
    }

    @Override
    public ExerciseSet toModel(ExerciseSetResponseDTO exerciseSetResponseDTO) {
        ExerciseSet exerciseSet = new ExerciseSet();

        exerciseSet.setLoad(exerciseSetResponseDTO.getLoad());
        exerciseSet.setRepetitions(exerciseSetResponseDTO.getRepetitions());
        exerciseSet.setExercise(exerciseMapper.toModel(exerciseSetResponseDTO.getExercise()));

        return exerciseSet;
    }
}
