package com.premium.premiumgym.micro;

import com.premium.premiumgym.trainingday.TrainingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicroService {

    @Autowired
    public MicroRepository microRepository;

    @Autowired
    public TrainingDayRepository trainingDayRepository;


    public Micro create(Micro micro)
    {
        return this.microRepository.save(micro);
    }

    public List<Micro> findAll()
    {
        return this.microRepository.findAll();
    }

    public Micro findMicroById(Long id)
    {
        return this.microRepository.findById(id).get();
    }

    public Micro update(Long id, Micro microDetails)
    {
        Micro micro = this.findMicroById(id);
        micro.copy(microDetails);

        return this.microRepository.save(micro);
    }

    public void delete(Long id)
    {
        this.microRepository.deleteById(id);
    }

    //Relationships

}
