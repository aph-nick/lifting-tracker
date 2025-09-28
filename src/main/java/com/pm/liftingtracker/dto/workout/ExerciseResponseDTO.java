package com.pm.liftingtracker.dto.workout;

import lombok.Getter;

import java.util.List;


@Getter
public class ExerciseResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private List<ExerciseSetResponseDTO> sets;
}
