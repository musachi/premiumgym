package com.premium.premiumgym.exercise.ExerciseExecution;

import com.premium.premiumgym.exercise.Execution.Execution;
import com.premium.premiumgym.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseExecutionRepository extends JpaRepository<ExerciseExecution, Long> {
    public List<Exercise> findExercisesByExecutionId(Long executionId);
    public List<Execution> findExecutionsByExerciseId(Long exerciseId);

    public ExerciseExecution findByExerciseIdAndExecutionId(Long exerciseId, Long executionId);
}