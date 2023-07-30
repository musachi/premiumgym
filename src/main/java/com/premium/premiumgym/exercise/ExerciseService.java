package com.premium.premiumgym.exercise;

import com.premium.premiumgym.classification.Classification;
import com.premium.premiumgym.classification.ClassificationRepository;
import com.premium.premiumgym.exercise.Execution.ExecutionRepository;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    public ExerciseRepository exerciseRepository;

    @Autowired
    public TargetRepository targetRepository;

    @Autowired
    public ClassificationRepository classificationRepository;

    @Autowired
    ExecutionRepository executionRepository;

    @Autowired
    ExerciseExecutionRepository exerciseExecutionRepository;

    public Exercise create(Exercise exercise){
        return this.exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll(){
        return this.exerciseRepository.findAll();
    }

    public Exercise findExerciseById(Long id){
        return this.exerciseRepository.findById(id).get();
    }

    public Exercise update(Long id, Exercise newExercise){
        Exercise exercise = this.findExerciseById(id);
        exercise.copy(newExercise);
        return exerciseRepository.save(exercise);
    }

    public void delete(Long id){
        this.exerciseRepository.deleteById(id);
    }

    //Relationship methods
    @Transactional
    public void addTargetToExercise(Long exerciseId, Long targetId)
    {
        Exercise exercise = this.findExerciseById(exerciseId);
        Target target = this.targetRepository.findById(targetId).get();
        exercise.addTarget(target);
        target.addExercise(exercise);

        this.targetRepository.save(target);
        this.exerciseRepository.save(exercise);
    }

    @Transactional
    public void addClassificationToExercise(Long exerciseId, Long classificationId)
    {
        Exercise exercise = this.findExerciseById(exerciseId);
        Classification classification = this.classificationRepository.findById(classificationId).get();

        exercise.addClassification(classification);
        classification.addExercise(exercise);

        classificationRepository.save(classification);
        this.exerciseRepository.save(exercise);
    }

    public List<Target> findTargetsByExerciseId(Long id)
    {
        return this.exerciseRepository.findById(id).get().getTargets();
    }

    public List<Classification> findClassificationsByExerciseId(Long id)
    {
        return this.exerciseRepository.findById(id).get().getClassifications();
    }

    @Transactional
    public void deleteTargetFromExercise(Long id, Long targetId)
    {
        Target target = this.targetRepository.findById(targetId).get();
        Exercise exercise = this.exerciseRepository.findById(id).get();

        exercise.getTargets().remove(target);
        this.exerciseRepository.save(exercise);
    }

    @Transactional
    public void deleteClassificationFromExercise(Long id, Long classificationId)
    {
        Classification classification = this.classificationRepository.findById(classificationId).get();
        Exercise exercise = this.exerciseRepository.findById(id).get();

        exercise.getTargets().remove(classification);
        this.exerciseRepository.save(exercise);
    }

    //TODO check for remove and use in other place
    public List<Exercise> getExercisesByTargetId(Long targetId)
    {
        return this.targetRepository.findById(targetId).get().getExercises();
    }

    public List<Exercise> getExercisesByClassificationId(Long classificationId)
    {
        return this.classificationRepository.findById(classificationId).get().getExercises();
    }

}
