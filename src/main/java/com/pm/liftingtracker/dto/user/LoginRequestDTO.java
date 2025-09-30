package com.pm.liftingtracker.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 100)
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 64)
    private String password;
}
