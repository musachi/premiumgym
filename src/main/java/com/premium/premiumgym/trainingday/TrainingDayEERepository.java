package com.premium.premiumgym.trainingday;

import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingDayEERepository extends JpaRepository<TrainingDayEE, Long> {
    //public List<Exercise> getExercisesByTrainingDay(Long trainingDayId);
}

