package com.pm.liftingtracker.mapper.workout;

import com.pm.liftingtracker.dto.workout.WorkoutRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.model.workout.Workout;
import org.springframework.stereotype.Component;

import javax.security.auth.kerberos.KerberosTicket;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class WorkoutMapper {

    private final ExerciseSetMapper exerciseSetMapper;

    public WorkoutMapper(ExerciseSetMapper exerciseSetMapper) {
        this.exerciseSetMapper = exerciseSetMapper;
    }

    public WorkoutResponseDTO toDto(Workout workout) {
        WorkoutResponseDTO dto = new WorkoutResponseDTO();

        dto.setName(workout.getName());
        dto.setStartTime(
                Optional.ofNullable(workout.getStartTime())
                        .map(LocalDateTime::toString)
                        .orElse(null)
        );

        dto.setEndTime(
                Optional.ofNullable(workout.getEndTime())
                        .map(LocalDateTime::toString)
                        .orElse(null)
        );
        dto.setExerciseSets(workout.getSets().stream()
                .map(exerciseSetMapper::toDto)
                .toList());

        return dto;
    }

    public Workout toModel(WorkoutRequestDTO workoutRequestDTO) {
        Workout workout = new Workout();

        workout.setName(workoutRequestDTO.getName());
        if (workoutRequestDTO.getStartTime() != null) {
            try {
                workout.setStartTime(LocalDateTime.parse(workoutRequestDTO.getStartTime()));
            } catch (DateTimeParseException e) {
                throw new RuntimeException("Niepoprawny format daty startTime: " + workoutRequestDTO.getStartTime(), e);
            }
        }

        if (workoutRequestDTO.getEndTime() != null) {
            try {
                workout.setEndTime(LocalDateTime.parse(workoutRequestDTO.getEndTime()));
            } catch (DateTimeParseException e) {
                throw new RuntimeException("Niepoprawny format daty endTime: " + workoutRequestDTO.getEndTime(), e);
            }
        }

        return workout;
    }
}
