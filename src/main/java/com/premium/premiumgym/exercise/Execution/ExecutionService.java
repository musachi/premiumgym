package com.premium.premiumgym.exercise.Execution;

import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionRepository;
import com.premium.premiumgym.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecutionService {

    @Autowired
    public ExecutionRepository executionRepository;

    @Autowired
    public SerieRepository serieRepository;

    @Autowired
    public ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseExecutionRepository exerciseExecutionRepository;

    public Execution create(Execution execution)
    {
        return this.executionRepository.save(execution);
    }
    
    public List<Execution> findAll()
    {
        return this.executionRepository.findAll();
    }
    
    public Execution findExecutionById(Long id){
        return this.executionRepository.findById(id).get();
    }

    public Execution update(Long id, Execution executionDetails)
    {
        Execution execution = this.findExecutionById(id);
        execution.copy(executionDetails);

        return this.executionRepository.save(execution);
    }
    
    public void delete(Long id)
    {
        this.executionRepository.deleteById(id);
    }

    public void addSerieToExecution(Long id, Long serieId)
    {
        Execution execution = this.executionRepository.findById(id).get();
        Serie serie = this.serieRepository.findById(serieId).get();

        serie.getExecutions().add(execution);
        execution.getSeries().add(serie);

        this.serieRepository.save(serie);
        this.executionRepository.save(execution);
    }

    //TODO check for remove
    public Execution addExercise(Long executionId, Long exerciseId)
    {
        Execution execution = this.findExecutionById(executionId);
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();

        ExerciseExecution ee = new ExerciseExecution();

        exercise.addExerciseExecution(ee);
        execution.addExerciseExecution(ee);

        ee.setExecution(execution);
        ee.setExercise(exercise);

        return this.exerciseExecutionRepository.save(ee).getExecution();
    }



}
