package com.pm.liftingtracker.service.workout;

import com.pm.liftingtracker.dto.workout.ExerciseRequestDTO;
import com.pm.liftingtracker.dto.workout.ExerciseResponseDTO;
import com.pm.liftingtracker.exception.ExerciseNotFoundException;
import com.pm.liftingtracker.mapper.workout.ExerciseMapper;
import com.pm.liftingtracker.model.workout.Exercise;
import com.pm.liftingtracker.repository.workout.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;
    private ExerciseMapper exerciseMapper;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
    }

    public ExerciseResponseDTO getExercise(Integer id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found"));

        return exerciseMapper.toDto(exercise);
    }

    public List<ExerciseResponseDTO> getExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();

        return exercises.stream().map(exerciseMapper::toDto).toList();
    }

    public ExerciseResponseDTO createExercise(ExerciseRequestDTO exerciseRequestDTO) {
        Exercise exercise = exerciseRepository.save(
                exerciseMapper.toModel(exerciseRequestDTO)
        );

        return exerciseMapper.toDto(exercise);
    }

    public ExerciseResponseDTO updateExercise(Integer id, ExerciseRequestDTO exerciseRequestDTO) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(
                () -> new ExerciseNotFoundException("Exercise with id: " + id + " not found")
        );

        exercise.setName(exerciseRequestDTO.getName());
        exercise.setDescription(exerciseRequestDTO.getDescription());

        exerciseRepository.save(exercise);
        return exerciseMapper.toDto(exercise);
    }

    public void deleteExercise(Integer id) {
        if (!exerciseRepository.existsById(id)) {
            throw new ExerciseNotFoundException("Exercise with id " + id + " not found");
        }
        exerciseRepository.deleteById(id);
    }
}
