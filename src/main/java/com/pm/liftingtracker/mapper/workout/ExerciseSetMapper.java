package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.ExerciseSetRequestDTO;
import com.pm.liftingtracker.dto.workout.ExerciseSetResponseDTO;
import com.pm.liftingtracker.model.workout.ExerciseSet;
import org.springframework.stereotype.Component;

@Component
public class ExerciseSetMapper {

    private final ExerciseMapper exerciseMapper;

    public ExerciseSetMapper(ExerciseMapper exerciseMapper) {
        this.exerciseMapper = exerciseMapper;
    }

    public ExerciseSetResponseDTO toDto(ExerciseSet exerciseSet) {
        ExerciseSetResponseDTO dto = new ExerciseSetResponseDTO();
        dto.setId(exerciseSet.getId());
        dto.setLoad(exerciseSet.getLoad());
        dto.setRepetitions(exerciseSet.getRepetitions());
        dto.setExercise(exerciseMapper.toDto(exerciseSet.getExercise()));

        return dto;
    }

    public ExerciseSet toModel(ExerciseSetRequestDTO dto) {
        ExerciseSet exerciseSet = new ExerciseSet();
        exerciseSet.setLoad(dto.getLoad());
        exerciseSet.setRepetitions(dto.getRepetitions());

        return exerciseSet;
    }
}
