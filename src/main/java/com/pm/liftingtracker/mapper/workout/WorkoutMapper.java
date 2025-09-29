package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.workout.Workout;

public class WorkoutMapper implements Mapper<WorkoutResponseDTO, Workout> {
    @Override
    public WorkoutResponseDTO toDto(Workout workout) {
        return null;
    }

    @Override
    public Workout toModel(WorkoutResponseDTO workoutResponseDTO) {
        return null;
    }
}
