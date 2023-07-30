package com.premium.premiumgym.classification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ClassificationRepository classificationRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        List<Classification> classifications = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        for (Category category : categoryRepository.findAll())
        {
            for (Classification classification : category.getClassifications()){
                classifications.add(classificationRepository.findById(classification.getId()).get());
            }
            category.setClassifications(classifications);
            categories.add(category);
        }
        return categories;
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category update(Long classificationTypeIdId, Category newCategory) {
        Category category = this.getCategory(classificationTypeIdId);
        category.copy(newCategory);
        return categoryRepository.save(category);
    }

    public void delete(Long typeId){
        if(this.getCategory(typeId) != null){
            this.categoryRepository.deleteById(typeId);
        }
    }

    public List<Classification> getClassificationsByCategoryId(Long id)
    {
        return this.categoryRepository.findById(id).get().getClassifications();
    }

    @Transactional
    public void addClassificationFromCategory(Long id, Long classificationId)
    {
        Category category = this.categoryRepository.findById(id).get();
        Classification classification = this.classificationRepository.findById(classificationId).get();

        classification.setCategory(category);
        category.addClassification(classification);

        this.classificationRepository.save(classification);
        this.categoryRepository.save(category);
    }

    @Transactional
    public void deleteClassificationFromCategory(Long id, Long classificationId)
    {
        Category category = this.categoryRepository.findById(id).get();
        Classification classification = this.classificationRepository.findById(classificationId).get();

        category.getClassifications().remove(classification);
        classification.setCategory(null);

        this.classificationRepository.save(classification);
        this.categoryRepository.save(category);
    }


}
