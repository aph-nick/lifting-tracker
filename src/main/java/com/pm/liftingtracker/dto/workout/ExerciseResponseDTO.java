package com.pm.liftingtracker.dto.workout;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ExerciseResponseDTO {
    private Integer id;
    private String name;
    private String description;
}
