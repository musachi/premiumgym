package com.premium.premiumgym.micro;


import com.premium.premiumgym.trainingday.TrainingDay;
import com.premium.premiumgym.trainingday.TrainingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MicroTrainingDayService {

    @Autowired
    public MicroRepository microRepository;

    @Autowired
    public TrainingDayRepository trainingDayRepository;

    @Transactional
    public void addTrainingDayToMicro(MicroTrainingDayDto microTrainingDayDto) {

        Micro micro = this.microRepository.findById(microTrainingDayDto.getMicroId()).get();
        TrainingDay trainingDay = this.trainingDayRepository.findById(microTrainingDayDto.getTrainingDayId()).get();

        MicroTrainingDay microTrainigDay = new MicroTrainingDay();
        microTrainigDay.setTrainingDay(trainingDay);
        microTrainigDay.setMicro(micro);
        microTrainigDay.setExecutionOrder(microTrainingDayDto.getExecutionOrder());

        micro.addTrainingDay(microTrainigDay);
        trainingDay.addMicro(microTrainigDay);

        this.microRepository.save(micro);
        this.trainingDayRepository.save(trainingDay);
    }

    @Transactional
    public void removeTrainingDayFromMicro(Long microId, Long trainingDayId){

        Micro micro = this.microRepository.findById(trainingDayId).get();
        TrainingDay trainingDay = this.trainingDayRepository.findById(trainingDayId).get();

        MicroTrainingDay microTrainigDay = new MicroTrainingDay();
        microTrainigDay.setTrainingDay(trainingDay);
        microTrainigDay.setMicro(micro);

        micro.removeTrainingDay(microTrainigDay);
        trainingDay.removeMicro(microTrainigDay);

        this.microRepository.save(micro);
        this.trainingDayRepository.save(trainingDay);
    }
}
