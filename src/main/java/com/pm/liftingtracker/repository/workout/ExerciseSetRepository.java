package com.pm.liftingtracker.repository.workout;

import com.pm.liftingtracker.model.workout.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Integer> {

}
