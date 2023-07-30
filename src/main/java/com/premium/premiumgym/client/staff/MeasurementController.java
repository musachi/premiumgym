package com.premium.premiumgym.client.staff;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.MEASUREMENTS)
public class MeasurementController{

    @Autowired
    public MeasurementService measurementService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Measurement create(@PathVariable Long id, @RequestBody Measurement measurement)
    {
        return this.measurementService.create(id, measurement);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Measurement> findAll(){
        return this.measurementService.findAll();
    }

    @RequestMapping(value = "/{measurementId}", method = RequestMethod.GET)
    public Measurement getMeasurement(@PathVariable Long measurementId)
    {
        return this.measurementService.findById(measurementId);
    }

    @RequestMapping(value = "/{measurementId}", method = RequestMethod.PUT)
    public Measurement update(@PathVariable Long measurementId, @RequestBody Measurement measurementDetails)
    {
        return this.measurementService.update(measurementId, measurementDetails);
    }

    @RequestMapping(value = "/{measurementId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long measurementId)
    {
        this.measurementService.deleteById(measurementId);
    }
}

