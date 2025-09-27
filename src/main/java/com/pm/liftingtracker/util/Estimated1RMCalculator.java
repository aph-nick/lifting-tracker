package com.pm.liftingtracker.util;

import com.pm.liftingtracker.model.workout.Exercise;
import com.pm.liftingtracker.model.workout.ExerciseSet;

import java.util.List;

public class Estimated1RMCalculator {
    Exercise exercise;


    public static double calculateEstimated1RM(Exercise exercise) {
        double estimated1RM = 0;
        ExerciseSet hardestSet = getHardestSet(exercise);

        // calculate 1rm

        return estimated1RM;
    }

    private static ExerciseSet getHardestSet(Exercise exercise) {
        List<ExerciseSet> sets = exercise.getSets();

        ExerciseSet hardestSet = null;
        for (ExerciseSet set : sets) {

        }
        return hardestSet;
    }
}

