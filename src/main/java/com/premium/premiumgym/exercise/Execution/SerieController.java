package com.premium.premiumgym.exercise.Execution;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.SERIES)
public class SerieController
{
    @Autowired
    public SerieService serieService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Serie create(@RequestBody Serie serie)
    {
        return this.serieService.create(serie);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Serie> findAll()
    {
        return this.serieService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Serie findSerieById(@PathVariable Long id)
    {
        return this.serieService.findSerieById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Serie update(@PathVariable Long id, @RequestBody Serie serieDetails)
    {
        return this.serieService.update(id, serieDetails);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        this.serieService.delete(id);
    }

    //TODO remove only for test
    public static List<Serie> generateSeries()
    {
        List<Serie> series = new ArrayList<>();

        for (int i = 0; i < 20; i++)
        {
            int executionOrder = ConstantValues.RANDOM.nextInt(3);
            int reps = ConstantValues.RANDOM.nextInt(3,15);
            Serie serie = new Serie();


            serie.setExecutionOrder(executionOrder);
            serie.setReps(reps);

            series.add(serie);
        }

        return series;
    }


}
