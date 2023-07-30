package com.premium.premiumgym.classification;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping(ConstantValues.CATEGORIES)
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getClassificationTypeById(@PathVariable(value = "id") Long id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Category update(@PathVariable(value = "id") Long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public boolean delete(@PathVariable(value = "id") Long id) {
        categoryService.delete(id);
        return true;
    }


}
