package com.pm.liftingtracker.service.workout;

import com.pm.liftingtracker.dto.workout.ExerciseSetRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.exception.ExerciseNotFoundException;
import com.pm.liftingtracker.exception.ExerciseSetNotFoundException;
import com.pm.liftingtracker.exception.WorkoutNotFoundException;
import com.pm.liftingtracker.mapper.workout.ExerciseSetMapper;
import com.pm.liftingtracker.mapper.workout.WorkoutMapper;
import com.pm.liftingtracker.model.workout.Exercise;
import com.pm.liftingtracker.model.workout.ExerciseSet;
import com.pm.liftingtracker.model.workout.Workout;
import com.pm.liftingtracker.repository.workout.ExerciseRepository;
import com.pm.liftingtracker.repository.workout.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseSetMapper exerciseSetMapper;
    private final WorkoutMapper workoutMapper;

    public WorkoutService(
            WorkoutRepository workoutRepository,
            ExerciseRepository exerciseRepository,
            WorkoutMapper workoutMapper,
            ExerciseSetMapper exerciseSetMapper) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseSetMapper = exerciseSetMapper;
        this.workoutMapper = workoutMapper;
    }

    public WorkoutResponseDTO getWorkoutById(Integer id) {
        Workout workout = getWorkoutOrThrow(id);

        return workoutMapper.toDto(workout);
    }

    public List<WorkoutResponseDTO> getWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();

        return workouts.stream()
                .map(workoutMapper::toDto).toList();
    }

    @Transactional
    public WorkoutResponseDTO createWorkout(WorkoutRequestDTO workoutRequestDTO) {
        Workout workout = workoutRepository.save(
                workoutMapper.toModel(workoutRequestDTO)
        );
        return workoutMapper.toDto(workout);
    }

    @Transactional
    public WorkoutResponseDTO updateWorkout(Integer id, WorkoutRequestDTO workoutRequestDTO) {
        Workout workout = getWorkoutOrThrow(id);

        workout.setName(workoutRequestDTO.getName());
        workoutRepository.save(workout);

        return workoutMapper.toDto(workout);
    }

    @Transactional
    public void deleteWorkout(Integer id) {
        if (!workoutRepository.existsById(id)) {
            throw new WorkoutNotFoundException("Workout with id " + id + " not found");
        }
        workoutRepository.deleteById(id);
    }

    @Transactional
    public WorkoutResponseDTO addExerciseToWorkout(Integer workoutId,  Integer exerciseId) {
        Workout workout = getWorkoutOrThrow(workoutId);
        Exercise exercise = getExerciseOrThrow(exerciseId);

        ExerciseSet exerciseSet = new ExerciseSet();
        exerciseSet.setExercise(exercise);
        exerciseSet.setWorkout(workout);

        exerciseSet.setLoad(0.0);
        exerciseSet.setRepetitions(0);

        workout.getSets().add(exerciseSet);
        workoutRepository.save(workout);
        return workoutMapper.toDto(workout);
    }

    @Transactional
    public WorkoutResponseDTO removeExerciseFromWorkout(Integer workoutId, Integer exerciseId) {
        Workout workout = getWorkoutOrThrow(workoutId);
        Exercise exercise = getExerciseOrThrow(exerciseId);

        List<ExerciseSet> toRemove = workout.getSets().stream()
                .filter(set -> set.getExercise().getId().equals(exerciseId))
                .toList();

        workout.getSets().removeAll(toRemove);
        workoutRepository.save(workout);

        return workoutMapper.toDto(workout);
    }

    @Transactional
    public WorkoutResponseDTO addExerciseSetsToWorkout(
            Integer workoutId, Integer exerciseId, List<ExerciseSetRequestDTO> exerciseSets) {
        Workout workout = getWorkoutOrThrow(workoutId);
        Exercise exercise = getExerciseOrThrow(exerciseId);

        for (ExerciseSetRequestDTO dto : exerciseSets) {
            ExerciseSet set = new ExerciseSet();
            set.setWorkout(workout);
            set.setExercise(exercise);
            set.setLoad(dto.getLoad());
            set.setRepetitions(dto.getRepetitions());

            workout.getSets().add(set);
        }

        workoutRepository.save(workout);
        return workoutMapper.toDto(workout);
    }

    @Transactional
    public WorkoutResponseDTO removeExerciseSetFromWorkout(
            Integer workoutId, Integer exerciseId, Integer exerciseSetId
    ) {
        Workout workout = getWorkoutOrThrow(workoutId);
        Exercise exercise = getExerciseOrThrow(exerciseId);

        ExerciseSet setToRemove = workout.getSets().stream().filter(
                set -> set.getId().equals(exerciseSetId)).findFirst().orElseThrow(
                () -> new ExerciseSetNotFoundException("Couldnt find set with id: " + exerciseSetId + " in exercise: " + exercise.getName())
        );

        workout.getSets().remove(setToRemove);
        workoutRepository.save(workout);
        return workoutMapper.toDto(workout);
    }

    private Workout getWorkoutOrThrow(Integer workoutId) {
        return workoutRepository.findById(workoutId)
                .orElseThrow(() -> new WorkoutNotFoundException("Workout not found with id: " + workoutId));
    }

    private Exercise getExerciseOrThrow(Integer exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with id: " + exerciseId));
    }
}
