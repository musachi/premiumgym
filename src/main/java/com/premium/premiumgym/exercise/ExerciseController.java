package com.premium.premiumgym.exercise;

import com.premium.premiumgym.classification.Classification;
import com.premium.premiumgym.exercise.Execution.Execution;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionService;
import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.EXERCISES)
public class ExerciseController {

    @Autowired
    public ExerciseService exerciseService;

    public ExerciseExecutionService exerciseExecutionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Exercise create(@RequestBody Exercise exercise){
        return this.exerciseService.create(exercise);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Exercise> findAll()
    {
        return exerciseService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Exercise findExerciseById(@PathVariable(value = "id") Long exerciseId)
    {
        return exerciseService.findExerciseById(exerciseId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Exercise update(@PathVariable(value = "id") Long exerciseId,
                                   @RequestBody Exercise newExercise){
        return this.exerciseService.update(exerciseId, newExercise);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long exerciseId){
        this.exerciseService.delete(exerciseId);
    }

    //Relationship Controllers
    //--------------------------------- ADD --------------------------------------
    @RequestMapping(value = "/{id}" + ConstantValues.TARGETS + "/{targetId}", method = RequestMethod.POST)
    public void addTargetToExercise(@PathVariable Long exerciseId, @PathVariable Long targetId)
    {
        this.exerciseService.addTargetToExercise(exerciseId, targetId);
    }

    @RequestMapping(value = "/{id}"+ ConstantValues.CLASSIFICATIONS + "/{classificationId}", method = RequestMethod.POST)
    public void addClassificationToExercise(@PathVariable Long exerciseId, @PathVariable Long classificationId)
    {
        this.exerciseService.addClassificationToExercise(exerciseId, classificationId);
    }

    @RequestMapping(value = "/{id}"+ ConstantValues.EXECUTIONS + "/{executionId}", method = RequestMethod.POST)
    public void addExecutionToExercise(@PathVariable Long exerciseId, @PathVariable Long executionId)
    {
        this.exerciseExecutionService.addExecutionToExercise(exerciseId, executionId);
    }

    //--------------------------------- FIND --------------------------------------
    @RequestMapping(value = "/{id}" + ConstantValues.TARGETS, method = RequestMethod.GET)
    public List<Target> findTargetsByExerciseId(@PathVariable Long exerciseId)
    {
        return this.exerciseService.findTargetsByExerciseId(exerciseId);
    }

    @RequestMapping(value = "/{id}" + ConstantValues.CLASSIFICATIONS, method = RequestMethod.GET)
    public List<Classification> findClassificationsByExerciseId(@PathVariable Long exerciseId)
    {
        return this.exerciseService.findClassificationsByExerciseId(exerciseId);
    }

    @RequestMapping(value = "/{id}" + ConstantValues.EXECUTIONS, method = RequestMethod.GET)
    public List<Execution> findExecutionsByExerciseId(@PathVariable Long exerciseId)
    {
        return exerciseExecutionService.findExecutionsByExerciseId(exerciseId);
    }

    //--------------------------------- DELETE --------------------------------------
    @RequestMapping(value = "/{id}" + ConstantValues.TARGETS + "/{targetId}", method = RequestMethod.DELETE)
    public void deleteTargetFromExercise(@PathVariable Long exerciseId, @PathVariable Long targetId)
    {
        this.exerciseService.addTargetToExercise(exerciseId, targetId);
    }

    @RequestMapping(value = "/{id}" + ConstantValues.CLASSIFICATIONS + "/{classificationId}", method = RequestMethod.DELETE)
    public void deleteClassificationFromExercise(@PathVariable Long exerciseId, @PathVariable Long classificationId)
    {
        this.exerciseService.deleteClassificationFromExercise(exerciseId, classificationId);
    }

    @RequestMapping(value = "/{id}" + ConstantValues.EXECUTIONS + "/{executionId}", method = RequestMethod.DELETE)
    public void deleteExecutionFromExercise(@PathVariable Long exerciseId, @PathVariable Long executionId)
    {
        this.exerciseExecutionService.findByExerciseIdAndExecutionId(exerciseId, executionId);
    }
}
