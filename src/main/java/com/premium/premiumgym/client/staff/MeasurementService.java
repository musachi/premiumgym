package com.premium.premiumgym.client.staff;

import com.premium.premiumgym.client.Client;
import com.premium.premiumgym.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    @Autowired
    public MeasurementRepository measurementRepository;

    @Autowired
    public ClientRepository clientRepository;

    public Measurement create(Long clientId, Measurement measurement)
    {
        Client client = clientRepository.findById(clientId).get();
        measurement.setClient(client);
        Measurement newMeasurement = this.measurementRepository.save(measurement);

        client.addMeasurement(measurement);
        clientRepository.save(client);

        return newMeasurement;
    }

    public List<Measurement> findAll()
    {
        return this.measurementRepository.findAll();
    }

    public Measurement findById(Long id)
    {
        return this.measurementRepository.findById(id).get();
    }

    public Measurement update(Long id, Measurement measurementDetails)
    {
        Measurement measurement = this.findById(id);
        measurement.copy(measurementDetails);

        return this.measurementRepository.save(measurement);
    }

    public void deleteById(Long id)
    {
        this.measurementRepository.deleteById(id);
    }
}
