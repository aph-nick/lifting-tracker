package com.pm.liftingtracker.model.workout;

import com.pm.liftingtracker.util.Estimated1RMCalculator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ExerciseSet> sets;

    private double estimated1RM;

    public double getEstimated1RM() {
        if (sets == null || sets.isEmpty()) {
            return 0.0;
        }
        return Estimated1RMCalculator.calculateEstimated1RM(this);
    }
}
