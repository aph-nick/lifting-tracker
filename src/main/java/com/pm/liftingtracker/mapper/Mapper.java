package com.pm.liftingtracker.mapper;

public interface Mapper<DTO, Model> {
    DTO toDto(Model model);
    Model toModel(DTO dto);
}
