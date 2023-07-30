package com.premium.premiumgym.client;

import com.premium.premiumgym.client.staff.Measurement;
import com.premium.premiumgym.client.staff.MeasurementRepository;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionRepository;
import com.premium.premiumgym.shift.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public MeasurementRepository measurementRepository;

    @Autowired
    ShiftRepository shiftRepository;

    @Autowired
    ExerciseExecutionRepository exerciseExecutionRepository;

    public Client create(Client client)
    {
        return this.clientRepository.save(client);
    }

    public List<Client> findAll()
    {
        return this.clientRepository.findAll();
    }

    public Client findClientById(Long id)
    {
        return this.clientRepository.findById(id).get();
    }

    public Client update(Long id, Client newClient)
    {
        Client client = this.findClientById(id);
        client.copy(newClient);

        return this.clientRepository.save(client);
    }

    public void delete(Long id)
    {
        this.clientRepository.deleteById(id);
    }


    //Relationsh
    public List<Measurement> findMeasurementsByClient(Long clientId){
        return measurementRepository.findByClient(clientId);
    }


}
