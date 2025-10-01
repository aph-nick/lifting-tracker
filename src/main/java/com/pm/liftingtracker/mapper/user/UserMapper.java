package com.pm.liftingtracker.mapper.user;

import com.pm.liftingtracker.dto.user.UserRequestDTO;
import com.pm.liftingtracker.dto.user.UserResponseDTO;
import com.pm.liftingtracker.mapper.workout.WorkoutMapper;
import com.pm.liftingtracker.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final WorkoutMapper workoutMapper;

    public UserMapper(WorkoutMapper workoutMapper) {
        this.workoutMapper = workoutMapper;
    }

    public UserResponseDTO toDto(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setWorkouts(user.getWorkouts().stream()
                .map(workoutMapper::toDto)
                .toList());

        return dto;
    }

    public User toModel(UserRequestDTO dto) {
        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        return user;
    }
}
