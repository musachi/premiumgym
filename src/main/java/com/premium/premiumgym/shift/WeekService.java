package com.premium.premiumgym.shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekService {
    @Autowired
    public WeekRepository weekRepository;

    public Week create(Week week)
    {
        return this.weekRepository.save(week);
    }

    public List<Week> findAll()
    {
        return this.weekRepository.findAll();
    }

    public Week getWeekById(Long id)
    {
        return this.weekRepository.findById(id).get();
    }

    public Week update(Long id, Week weekDetails)
    {
        Week week = this.getWeekById(id);
        week.copy(weekDetails);

        return this.weekRepository.save(week);
    }

    public void delete(Long id)
    {
        this.weekRepository.deleteById(id);
    }


}
