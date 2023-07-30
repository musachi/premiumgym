package com.premium.premiumgym.exercise.Execution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    public SerieRepository serieRepository;

    @Autowired
    public ExecutionRepository executionRepository;

    public Serie create(Serie serie)
    {
        return this.serieRepository.save(serie);
    }

    public List<Serie> findAll()
    {
        return this.serieRepository.findAll();
    }

    public Serie findSerieById(Long id)
    {
        return this.serieRepository.findById(id).get();
    }

    public Serie update(Long id, Serie serieDetails)
    {
        Serie serie = this.serieRepository.findById(id).get();
        serie.copy(serieDetails);

        return this.serieRepository.save(serie);
    }

    public void delete(Long id)
    {
        this.serieRepository.deleteById(id);
    }

    public List<Serie> findByExecutions(Long executionId)
    {
        Execution execution = executionRepository.findById(executionId).get();
        return this.serieRepository.findByExecutions(execution);
    }
}
