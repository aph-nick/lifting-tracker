package com.pm.liftingtracker.service.workout;

import com.pm.liftingtracker.repository.workout.ExerciseRepository;
import com.pm.liftingtracker.repository.workout.ExerciseSetRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;

    public ExerciseSetService(ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }


}
