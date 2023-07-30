package com.premium.premiumgym.exercise.ExerciseExecution;

import com.premium.premiumgym.exercise.Execution.Execution;
import com.premium.premiumgym.exercise.Execution.ExecutionRepository;
import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ExerciseExecutionService {
    @Autowired
    public ExerciseExecutionRepository exerciseExecutionRepository;

    @Autowired
    public ExerciseRepository exerciseRepository;

    @Autowired
    public ExecutionRepository executionRepository;

    public ExerciseExecution
    create(ExerciseExecution exerciseExecution)
    {
        return this.exerciseExecutionRepository.save(exerciseExecution);
    }

    public List<ExerciseExecution>
    findAll()
    {
        return this.exerciseExecutionRepository.findAll();
    }

    public ExerciseExecution
    getExerciseExecutionById(Long id)
    {
        return this.exerciseExecutionRepository.findById(id).get();
    }

    public ExerciseExecution
    update(Long id, ExerciseExecution exerciseExecutionDetails)
    {
        ExerciseExecution exerciseExecution = this.getExerciseExecutionById(id);
        exerciseExecution.copy(exerciseExecutionDetails);

        return this.exerciseExecutionRepository.save(exerciseExecution);
    }

    public void
    delete(Long id)
    {
        this.exerciseExecutionRepository.deleteById(id);
    }

    public List<Exercise> findExercisesByExecutionId(Long executionId)
    {
        return this.exerciseExecutionRepository.findExercisesByExecutionId(executionId);
    }
    public List<Execution> findExecutionsByExerciseId(Long exerciseId)
    {
        return this.exerciseExecutionRepository.findExecutionsByExerciseId(exerciseId);
    }

    @Transactional
    public ExerciseExecution findByExerciseIdAndExecutionId(Long exerciseId, Long executionId) {
        ExerciseExecution exerciseExecution = this.exerciseExecutionRepository.findByExerciseIdAndExecutionId(exerciseId, executionId);
        return exerciseExecution;
    }

    @Transactional
    public Exercise addExecutionToExercise(Long exerciseId, Long executionId)
    {
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();
        Execution execution = this.executionRepository.findById(executionId).get();

        ExerciseExecution exerciseExecution = new ExerciseExecution();
        exerciseExecution.setExecution(execution);
        exerciseExecution.setExercise(exercise);

        exercise.addExerciseExecution(exerciseExecution);
        execution.addExerciseExecution(exerciseExecution);

        this.executionRepository.save(execution);
        return this.exerciseRepository.save(exercise);
    }

    @Transactional
    public void removeExeccutionFromExercise(Long exerciseId, Long executionId)
    {
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();
        Execution execution = this.executionRepository.findById(executionId).get();

        ExerciseExecution exerciseExecution = findByExerciseIdAndExecutionId(exerciseId, executionId);

        this.delete(exerciseExecution.getId());
        exercise.getExerciseExecutions().remove(exerciseExecution);
        execution.getExerciseExecutions().remove(exerciseExecution);

        this.exerciseRepository.save(exercise);
        this.executionRepository.save(execution);
    }
}
