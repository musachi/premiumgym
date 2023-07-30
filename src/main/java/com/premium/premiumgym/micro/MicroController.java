package com.premium.premiumgym.micro;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.MICROS)
public class MicroController {
    @Autowired
    public MicroService microService;

    @Autowired
    public MicroTrainingDayService microTrainingDayService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Micro create(@PathVariable Micro micro)
    {
        return this.microService.create(micro);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Micro> findAll()
    {
        return this.microService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Micro findMicroById(@PathVariable Long id)
    {
        return this.microService.findMicroById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Micro update(@PathVariable Long id, @RequestBody Micro microDetails)
    {
        return this.microService.update(id, microDetails);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        this.microService.delete(id);
    }

    @RequestMapping(value = "/{id}/" + ConstantValues.TRAININGDAYS + "/{training_day_id}"
            , method = RequestMethod.POST)
    public void addTrainingDayToMicro(@PathVariable Long id, @PathVariable Long training_day_id, @RequestBody Integer executionOrder)
    {
        MicroTrainingDayDto microTrainingDayDto = new MicroTrainingDayDto();
        microTrainingDayDto.setMicroId(id);
        microTrainingDayDto.setTrainingDayId(training_day_id);
        microTrainingDayDto.setExecutionOrder(executionOrder);

        microTrainingDayService.addTrainingDayToMicro(microTrainingDayDto);
    }

    @RequestMapping(value = "/{id}/" + ConstantValues.TRAININGDAYS + "/{training_day_id}"
            , method = RequestMethod.DELETE)
    public void removeTrainingDayFromMicro(@PathVariable Long id, @PathVariable Long training_day_id)
    {
        microTrainingDayService.removeTrainingDayFromMicro(id, training_day_id);
    }
}
