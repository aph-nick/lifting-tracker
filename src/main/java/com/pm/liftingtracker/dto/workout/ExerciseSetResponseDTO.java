package com.pm.liftingtracker.dto.workout;

import com.pm.liftingtracker.model.workout.Exercise;

public class ExerciseSetResponseDTO {

    private Integer id;
    private Double load;
    private Integer repetitions;
    private Exercise exercise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLoad() {
        return load;
    }

    public void setLoad(Double load) {
        this.load = load;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
