package com.pm.liftingtracker.controller.workout;

import com.pm.liftingtracker.dto.workout.ExerciseResponseDTO;
import com.pm.liftingtracker.dto.workout.ExerciseSetRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutRequestDTO;
import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import com.pm.liftingtracker.service.workout.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutResponseDTO> getWorkoutById(@PathVariable Integer id) {
        WorkoutResponseDTO workout = workoutService.getWorkoutById(id);

        return ResponseEntity.ok(workout);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutResponseDTO>> getAllWorkouts() {
        List<WorkoutResponseDTO> workouts = workoutService.getWorkouts();

        return ResponseEntity.ok(workouts);
    }

    @PostMapping
    public ResponseEntity<WorkoutResponseDTO> createWorkout(
            @Valid @RequestBody WorkoutRequestDTO workoutRequestDTO
    ) {
        WorkoutResponseDTO workout = workoutService.createWorkout(workoutRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(workout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutResponseDTO> updateWorkout(
        @PathVariable Integer id, @Valid @RequestBody WorkoutRequestDTO workoutRequestDTO
    ) {
        WorkoutResponseDTO workout = workoutService.updateWorkout(id, workoutRequestDTO);

        return ResponseEntity.ok(workout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkoutResponseDTO> deleteWorkout(@PathVariable Integer id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{workoutId}/exercises/{exerciseId}")
    public ResponseEntity<WorkoutResponseDTO> addExerciseToWorkout(
        @PathVariable Integer workoutId, @PathVariable Integer exerciseId
    ) {
        WorkoutResponseDTO updatedWorkout = workoutService.addExerciseToWorkout(workoutId, exerciseId);

        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{workoutId}/exercises/{exerciseId}")
    public ResponseEntity<WorkoutResponseDTO> removeExerciseFromWorkout(
            @PathVariable Integer workoutId, @PathVariable Integer exerciseId
    ) {
        WorkoutResponseDTO updatedWorkout = workoutService.removeExerciseFromWorkout(workoutId, exerciseId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{workoutId}/exercises/{exerciseId}/sets")
    public ResponseEntity<WorkoutResponseDTO> addExerciseSetsToWorkout(
            @PathVariable Integer workoutId,
            @PathVariable Integer exerciseId,
            @Valid @RequestBody List<ExerciseSetRequestDTO> exerciseSets
    ) {
        WorkoutResponseDTO updatedWorkout = workoutService.addExerciseSetsToWorkout(
                workoutId, exerciseId, exerciseSets);

        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{workoutId}/exercises/{exerciseId}/sets/{setId}")
    public ResponseEntity<WorkoutResponseDTO> removeExerciseSetFromWorkout(
            @PathVariable Integer workoutId,
            @PathVariable Integer exerciseId,
            @PathVariable Integer setId
    ){
        WorkoutResponseDTO updatedWorkout = workoutService.removeExerciseSetFromWorkout(
                workoutId, exerciseId, setId);

        return ResponseEntity.noContent().build();
    }
}
