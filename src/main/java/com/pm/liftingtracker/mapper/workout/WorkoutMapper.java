package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.Workout;

public class WorkoutMapper implements Mapper<WorkoutResponseDTO, Workout> {

    private final ExerciseMapper exerciseMapper;

    public WorkoutMapper(ExerciseMapper exerciseMapper) {
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public WorkoutResponseDTO toDto(Workout workout) {
        WorkoutResponseDTO dto = new WorkoutResponseDTO();

        dto.setName(workout.getName());
        dto.setExercises(workout.getExercises().stream()
                .map(exerciseMapper::toDto)
                .toList());

        return dto;
    }

    @Override
    public Workout toModel(WorkoutResponseDTO workoutResponseDTO) {
        Workout workout = new Workout();

        workout.setName(workoutResponseDTO.getName());
        workout.setExercises(workoutResponseDTO.getExercises().stream()
                .map(exerciseMapper::toModel)
                .toList());

        return workout;
    }
}
