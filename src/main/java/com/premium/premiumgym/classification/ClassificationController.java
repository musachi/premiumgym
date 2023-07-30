package com.premium.premiumgym.classification;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(ConstantValues.CLASSIFICATIONS_CONTROLLER)
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Classification create(@PathVariable(value = "id") Long typeId, @RequestBody Classification classification) {
        //return classificationTypeService.createClassification(typeId, classification);
        return classificationService.create(typeId, classification);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Classification> findAll(@PathVariable(value = "id") Long typeId){
        List<Classification> classifications = classificationService.findClassificationsByType(typeId);
        classifications.sort(Comparator.comparingLong(Classification::getId));

        return classifications;
    }

    @RequestMapping(value = "/{classificationId}", method = RequestMethod.GET)
    public Classification findById(@PathVariable(value = "id") Long typeId, @PathVariable Long classificationId){
        return classificationService.findClassificationById(classificationId);
    }

    @RequestMapping(value = "/{classificationId}", method = RequestMethod.PUT)
    public Classification update(@PathVariable(value = "id") Long typeId, @PathVariable Long classificationId, @RequestBody Classification classification){
        return classificationService.update(classificationId, classification);
    }

    @RequestMapping(value = "/{classificationId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long typeId, @PathVariable Long classificationId){
        categoryService.deleteClassificationFromCategory(typeId, classificationId);
        classificationService.delete(classificationId);
    }
}
