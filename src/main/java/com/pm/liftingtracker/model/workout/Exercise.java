package com.pm.liftingtracker.model.workout;

import com.pm.liftingtracker.util.Estimated1RMCalculator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

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


    private double estimated1RM; // util package will calculate this value

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimated1RM() {
        if (sets == null || sets.isEmpty()) {
            return 0.0;
        }
        return Estimated1RMCalculator.calculateEstimated1RM(this);
    }

    public void setEstimaed1RM(double estimated1RM) {
        this.estimated1RM = estimated1RM;
    }

    public List<ExerciseSet> getSets() {
        return sets;
    }

    public void setSets(List<ExerciseSet> sets) {
        this.sets = sets;
    }

}
