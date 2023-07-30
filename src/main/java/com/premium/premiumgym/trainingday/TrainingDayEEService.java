package com.premium.premiumgym.trainingday;

import com.premium.premiumgym.exercise.Exercise;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingDayEEService {

    @Autowired
    public TrainingDayEERepository trainingDayEERepository;

    @Autowired
    public TrainingDayRepository trainingDayRepository;

    @Autowired
    public ExerciseExecutionRepository exerciseExecutionRepository;

    public TrainingDayEE createTrainingDayEE(TrainingDayEE trainingDayEE)
    {
        return this.trainingDayEERepository.save(trainingDayEE);
    }

    public List<TrainingDayEE> getTrainingDayEES()
    {
        return this.trainingDayEERepository.findAll();
    }

    public TrainingDayEE getTrainingDayEE(Long id)
    {
        return this.trainingDayEERepository.findById(id).get();
    }

    public TrainingDayEE updateTrainingDayEE(Long id, TrainingDayEE newTrainingDayEE)
    {
        TrainingDayEE trainingDayEE = this.getTrainingDayEE(id);
        trainingDayEE.copy(newTrainingDayEE);

        return this.trainingDayEERepository.save(trainingDayEE);
    }

    public void deleteTrainingDayEE(Long id)
    {
        this.trainingDayEERepository.deleteById(id);
    }

    @Autowired
    public TrainingDayEERepoEM trainingDayEERepoEM;
    public List<TrainingDayEE> findByTrainingDayId(Long trainindDayId)
    {
        return trainingDayEERepoEM.findByTrainingDayId(trainindDayId);
    }

    public List<Exercise> getExercisesByTrainingDay(Long trainingDayId)
    {
        List<TrainingDayEE> trainingDayEEList = this.findByTrainingDayId(trainingDayId);
        //trainingDayEEList.sort(Comparator.comparingInt(TrainingDayEE::getExerciseExecutionOrder));

        List<Exercise> exerciseList = new ArrayList<>();
        for (TrainingDayEE t : trainingDayEEList){
            exerciseList.add(t.getExerciseExecution().getExercise());
        }

        return exerciseList;
    }

    public TrainingDay addExerciseExecutionToTrainingDay(Long trainingDayId, Long exerciseExecutionId, Long exerciseExecutionOrder)
    {
        TrainingDay trainingDay = this.trainingDayRepository.findById(trainingDayId).get();
        ExerciseExecution exerciseExecution = exerciseExecutionRepository.findById(exerciseExecutionId).get();

        TrainingDayEE tdee = new TrainingDayEE();
        tdee.setTrainingDay(trainingDay);
        tdee.setExerciseExecution(exerciseExecution);
        tdee.setExerciseExecutionOrder(exerciseExecutionOrder);

        trainingDay.addExerciseExecution(tdee);
        exerciseExecution.addTrainingDay(tdee);

        return this.trainingDayEERepository.save(tdee).getTrainingDay();
    }
}
