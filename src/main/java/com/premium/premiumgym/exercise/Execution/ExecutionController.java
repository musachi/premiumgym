package com.premium.premiumgym.exercise.Execution;

import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "executions")
public class ExecutionController {

    @Autowired
    public ExecutionService executionService;
    @Autowired
    private ExerciseExecutionRepository exerciseExecutionService;

    @RequestMapping(method = RequestMethod.POST)
    public Execution createExecution(@RequestBody Execution execution)
    {
        return this.executionService.create(execution);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Execution> findAll()
    {
        return this.executionService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Execution findExecutionById(@PathVariable Long id)
    {
        return this.executionService.findExecutionById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Execution update(@PathVariable Long id, @RequestBody Execution execution)
    {
        return this.executionService.update(id, execution);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        this.executionService.delete(id);
    }

    @RequestMapping(value = "/{id}/exercises", method = RequestMethod.GET)
    public List<Exercise> findExercisesByExecution(@PathVariable(value = "id") Long executionId)
    {
        return this.exerciseExecutionService.findExercisesByExecutionId(executionId);
    }

    @Autowired
    public SerieService serieService;
    @RequestMapping(value = "/{id}/series", method = RequestMethod.GET)
    public List<Serie> findSeriesByExecutions(@PathVariable(value = "id") Long executionId)
    {
        return this.serieService.findByExecutions(executionId);
    }
}
