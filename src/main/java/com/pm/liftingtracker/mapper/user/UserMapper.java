package com.pm.liftingtracker.mapper.user;

import com.pm.liftingtracker.dto.user.UserResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.mapper.workout.WorkoutMapper;
import com.pm.liftingtracker.model.user.User;

public class UserMapper implements Mapper<UserResponseDTO, User> {

    private final WorkoutMapper workoutMapper;

    public UserMapper(WorkoutMapper workoutMapper) {
        this.workoutMapper = workoutMapper;
    }

    @Override
    public UserResponseDTO toDto(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setWorkouts(user.getWorkouts().stream()
                .map(workoutMapper::toDto)
                .toList());

        return dto;
    }

    @Override
    public User toModel(UserResponseDTO dto) {
        User user = new User();

        user.setUsername(dto.getUsername());
        user.setWorkouts(dto.getWorkouts().stream()
                .map(workoutMapper::toModel)
                .toList());

        return user;
    }
}
