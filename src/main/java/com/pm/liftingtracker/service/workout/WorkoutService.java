package com.pm.liftingtracker.service.workout;

import com.pm.liftingtracker.dto.workout.WorkoutRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.mapper.workout.WorkoutMapper;
import com.pm.liftingtracker.model.workout.Workout;
import com.pm.liftingtracker.repository.workout.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;

    public WorkoutService(WorkoutRepository workoutRepository,  WorkoutMapper workoutMapper) {
        this.workoutRepository = workoutRepository;
        this.workoutMapper = workoutMapper;
    }

    public List<WorkoutResponseDTO> getWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();

        return workouts.stream()
                .map(workoutMapper::toDto).toList();
    }

    public WorkoutResponseDTO createWorkout(WorkoutRequestDTO workoutRequestDTO) {
        Workout workout = workoutRepository.save(
                workoutMapper.toModel(workoutRequestDTO)
        );
        return workoutMapper.toDto(workout);
    }

}
