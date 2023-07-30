package com.premium.premiumgym.exercise;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ConstantValues.TARGETS)
public class TargetController {

    @Autowired
    public TargetService targetService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Target createTarget(@RequestBody Target target){
        return this.targetService.create(target);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Target> findAll(){
        return targetService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Target getTarget(@PathVariable(value = "id") Long targetId){
        return this.targetService.getTarget(targetId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Target updateTargetId(@PathVariable(value = "id") Long targetId, @RequestBody Target newTarget){
        return this.targetService.update(targetId, newTarget);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTarget(@PathVariable(value = "id") Long targetId){
        this.targetService.delete(targetId);
    }


}
