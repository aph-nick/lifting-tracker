package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.WorkoutRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.model.workout.Workout;
import org.springframework.stereotype.Component;

@Component
public class WorkoutMapper {

    private final ExerciseSetMapper exerciseSetMapper;

    public WorkoutMapper(ExerciseSetMapper exerciseSetMapper) {
        this.exerciseSetMapper = exerciseSetMapper;
    }

    public WorkoutResponseDTO toDto(Workout workout) {
        WorkoutResponseDTO dto = new WorkoutResponseDTO();

        dto.setName(workout.getName());
        dto.setExerciseSets(workout.getSets().stream()
                .map(exerciseSetMapper::toDto)
                .toList());

        return dto;
    }

    public Workout toModel(WorkoutRequestDTO workoutRequestDTO) {
        Workout workout = new Workout();

        workout.setName(workoutRequestDTO.getName());

        return workout;
    }
}
