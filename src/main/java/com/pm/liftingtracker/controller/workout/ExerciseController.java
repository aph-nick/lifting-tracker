package com.pm.liftingtracker.controller.workout;

import com.pm.liftingtracker.dto.workout.ExerciseRequestDTO;
import com.pm.liftingtracker.dto.workout.ExerciseResponseDTO;
import com.pm.liftingtracker.service.workout.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponseDTO> getExercise(@PathVariable Integer id) {
        ExerciseResponseDTO exercise = exerciseService.getExercise(id);
        return ResponseEntity.ok(exercise);
    }

    @GetMapping
    public ResponseEntity<List<ExerciseResponseDTO>> getExercises() {
        List<ExerciseResponseDTO> exercises = exerciseService.getExercises();

        return ResponseEntity.ok(exercises);
    }

    @PostMapping
    public ResponseEntity<ExerciseResponseDTO> createExercise(
            @Valid @RequestBody ExerciseRequestDTO exerciseRequestDTO
    ) {
        ExerciseResponseDTO exercise = exerciseService.createExercise(exerciseRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseResponseDTO> updateExercise(
            @PathVariable Integer id, @Valid @RequestBody ExerciseRequestDTO exerciseRequestDTO
    ) {
        ExerciseResponseDTO exercise = exerciseService.updateExercise(id, exerciseRequestDTO);

        return ResponseEntity.ok(exercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Integer id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
