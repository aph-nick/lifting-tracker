package com.pm.liftingtracker.service.workout;

import com.pm.liftingtracker.repository.workout.ExerciseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

}
