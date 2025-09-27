package com.pm.liftingtracker.dto.user;

import com.pm.liftingtracker.model.workout.Workout;

import java.util.List;

public class UserResponseDTO {

    private Integer id;
    private String username;
    private String password;
    private List<Workout> workouts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

}
