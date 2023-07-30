package com.premium.premiumgym.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetService {

    @Autowired
    public TargetRepository targetRepository;

    @Autowired
    public ExerciseRepository exerciseRepository;

    public Target create(Target target){
        return this.targetRepository.save(target);
    }

    public List<Target> findAll(){
        return targetRepository.findAll();
    }

    public Target getTarget(Long id) {
        return this.targetRepository.findById(id).get();
    }

    public Target update(Long id, Target newTarget) {
        Target target = targetRepository.findById(id).get();
        target.copy(newTarget);
        return this.targetRepository.save(target);
    }

    public void delete(Long id) {
        targetRepository.deleteById(id);
    }

    public List<Exercise> findExercisesByTargetId(Long id)
    {
        return this.targetRepository.findById(id).get().getExercises();
    }

    /*@Transactional
    public Target addExerciseToTarget(Long id, Long exerciseId){
        Target target = this.getTarget(id);
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();
        target.addExercise(exercise);

        return this.targetRepository.save(target);
    }*/

}
