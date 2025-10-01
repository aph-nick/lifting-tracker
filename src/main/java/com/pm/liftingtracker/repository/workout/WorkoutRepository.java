package com.pm.liftingtracker.repository.workout;

import com.pm.liftingtracker.model.workout.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
