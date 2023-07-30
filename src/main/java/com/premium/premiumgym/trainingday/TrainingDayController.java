package com.premium.premiumgym.trainingday;

import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.TRAININGDAYS)
public class TrainingDayController {

    @Autowired
    public TrainingDayService trainingDayService;

    @Autowired
    public TrainingDayEEService trainingDayEEService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public TrainingDay create(@RequestBody TrainingDay t)
    {
        return this.trainingDayService.create(t);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingDay> findAll()
    {
        return this.trainingDayService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TrainingDay findTrainingDayById(@PathVariable Long id)
    {
        return this.trainingDayService.findTrainingDayById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TrainingDay update(@PathVariable Long id, @RequestBody TrainingDay newTrainingDay)
    {
        return this.trainingDayService.update(id, newTrainingDay);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        this.trainingDayService.delete(id);
    }

    @RequestMapping(value = "/{id}/exercises/{exercise_id}", method = RequestMethod.POST)
    public TrainingDay addExerciseExecutionToTrainingDay(@PathVariable Long id, @PathVariable Long exercise_id,
                                   @RequestBody Long exerciseExecutionOrder)
    {
        return this.trainingDayEEService.addExerciseExecutionToTrainingDay(id, exercise_id, exerciseExecutionOrder);
    }

    @RequestMapping(value = "/{id}/exercises", method = RequestMethod.GET)
    public List<Exercise> getExercises(@PathVariable Long id)
    {
        return this.trainingDayEEService.getExercisesByTrainingDay(id);
    }


}
