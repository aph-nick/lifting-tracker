package com.pm.liftingtracker.dto.user;

import com.pm.liftingtracker.dto.workout.WorkoutResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserResponseDTO {

    private Integer id;
    private String username;
    private List<WorkoutResponseDTO> workouts;
}
