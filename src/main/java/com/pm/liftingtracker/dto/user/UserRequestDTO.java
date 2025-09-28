package com.pm.liftingtracker.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserRequestDTO {

    @NotBlank(message = "username of the user cannot be empty")
    @Size(max = 100, message = "username cannot exceed 100 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,64}$",
            message = "Password must contain at least one digit, one uppercase letter, one lowercase letter, one special character and be 8-64 characters long"
    )
    private String password;
}
