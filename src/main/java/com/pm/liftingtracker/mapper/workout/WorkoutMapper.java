package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.ExerciseSet;
import com.pm.liftingtracker.model.workout.Workout;

public class WorkoutMapper implements Mapper<WorkoutResponseDTO, Workout> {

    private final ExerciseSetMapper exerciseSetMapper;

    public WorkoutMapper(ExerciseSetMapper exerciseSetMapper) {
        this.exerciseSetMapper = exerciseSetMapper;
    }

    @Override
    public WorkoutResponseDTO toDto(Workout workout) {
        WorkoutResponseDTO dto = new WorkoutResponseDTO();

        dto.setName(workout.getName());
        dto.setExerciseSets(workout.getSets().stream()
                .map(exerciseSetMapper::toDto)
                .toList());

        return dto;
    }

    @Override
    public Workout toModel(WorkoutResponseDTO workoutResponseDTO) {
        Workout workout = new Workout();

        workout.setName(workoutResponseDTO.getName());
        workout.setSets(workoutResponseDTO.getExerciseSets().stream()
                .map(exerciseSetMapper::toModel)
                .toList());

        return workout;
    }
}
