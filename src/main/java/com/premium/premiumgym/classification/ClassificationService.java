package com.premium.premiumgym.classification;

import com.premium.premiumgym.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.premium.premiumgym.exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificationService {
    @Autowired
    public ClassificationRepository classificationRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public ExerciseRepository excerciseRepository;

    public Classification create(Long typeId, Classification classification){
        Category category = categoryRepository.findById(typeId).get();
        classification.setCategory(category);

        return classificationRepository.save(classification);
    }

    public Classification findClassificationById(Long classificationId){
        return this.classificationRepository.findById(classificationId).get();
    }

    public Classification update(Long classificationId, Classification newClassification){
        Classification c = this.findClassificationById(classificationId);
        c.copy(newClassification);
        return this.classificationRepository.save(c);
    }

    public void delete(Long classificationId){
        this.classificationRepository.deleteById(classificationId);
    }

    //TODO decide if convert each element in ClassificationDto
    public List<ClassificationDto> getClassifications(Long typeId){
        List<ClassificationDto> classificationDtos = new ArrayList<>();
        this.classificationRepository.findAll().forEach((classification -> {
            classificationDtos.add(new ClassificationDto(classification));
        }));

        return classificationDtos;
    }

    public List<Classification> findClassificationsByType(Long typeId){
        return this.categoryRepository.findById(typeId)
                .get().getClassifications();
    }

    public Classification addExercise(Long classificationId, Long exerciseId){
        Classification classification = this.findClassificationById(classificationId);
        Exercise exercise = excerciseRepository.findById(exerciseId).get();

        classification.addExercise(exercise);
        exercise.addClassification(classification);

        return this.classificationRepository.save(classification);
    }
}
