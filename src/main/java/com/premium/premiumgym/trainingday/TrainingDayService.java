package com.premium.premiumgym.trainingday;

import com.premium.premiumgym.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingDayService {
    @Autowired
    public TrainingDayRepository trainingDayRepository;
    private ExerciseRepository excerciseRepository;

    public TrainingDay create(TrainingDay trainingDay)
    {
        return this.trainingDayRepository.save(trainingDay);
    }

    public List<TrainingDay> findAll()
    {
        return this.trainingDayRepository.findAll();
    }

    public TrainingDay findTrainingDayById(Long id)
    {
        return this.trainingDayRepository.findById(id).get();
    }

    public TrainingDay update(Long id, TrainingDay newTrainingDay)
    {
        TrainingDay trainingDay = this.trainingDayRepository.findById(id).get();
        trainingDay.copy(newTrainingDay);

        return this.trainingDayRepository.save(trainingDay);
    }
    public void delete(Long id)
    {
        this.trainingDayRepository.deleteById(id);
    }

    //Relationships
}
