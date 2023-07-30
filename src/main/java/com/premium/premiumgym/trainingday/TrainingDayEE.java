package com.premium.premiumgym.trainingday;

import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import com.premium.premiumgym.zconfig.Queries;
import jakarta.persistence.*;

@Entity
@Table(name = "training_day_e_e")
@NamedQueries({
        @NamedQuery(name = Queries.FIND_BY_TRAINING_DAY_ID_VAR_NAME, query = Queries.FIND_BY_TRAINING_DAY_ID)
})
public class TrainingDayEE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_day_exercise_execution_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_execution_id", nullable = false)
    private ExerciseExecution exerciseExecution;

    @ManyToOne
    @JoinColumn(name = "\"TRAINING_DAY_ID\"", nullable = false)
    private TrainingDay trainingDay;

    private Long exerciseExecutionOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExerciseExecution getExerciseExecution() {
        return exerciseExecution;
    }

    public void setExerciseExecution(ExerciseExecution exerciseExecution) {
        this.exerciseExecution = exerciseExecution;
    }

    public TrainingDay getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(TrainingDay trainingDay) {
        this.trainingDay = trainingDay;
    }

    public Long getExerciseExecutionOrder() {
        return exerciseExecutionOrder;
    }

    public void setExerciseExecutionOrder(Long exerciseExecutionOrder) {
        this.exerciseExecutionOrder = exerciseExecutionOrder;
    }

    public void copy(TrainingDayEE newTrainingDayEE) {
        this.trainingDay = newTrainingDayEE.getTrainingDay();
        this.exerciseExecution = newTrainingDayEE.getExerciseExecution();
        this.exerciseExecutionOrder = newTrainingDayEE.getExerciseExecutionOrder();
    }
}
