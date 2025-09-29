package com.pm.liftingtracker.mapper.user;

import com.pm.liftingtracker.dto.user.UserResponseDTO;
import com.pm.liftingtracker.mapper.Mapper;
import com.pm.liftingtracker.model.user.User;

public class UserMapper implements Mapper<UserResponseDTO, User> {
    @Override
    public UserResponseDTO toDto(User model) {
        return null;
    }

    @Override
    public User toModel(UserResponseDTO dto) {
        return null;
    }
}
