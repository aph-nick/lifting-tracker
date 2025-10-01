package com.pm.liftingtracker.repository.workout;

import com.pm.liftingtracker.model.workout.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
