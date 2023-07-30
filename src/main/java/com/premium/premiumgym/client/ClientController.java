package com.premium.premiumgym.client;

import com.premium.premiumgym.client.staff.Measurement;
import com.premium.premiumgym.client.staff.MeasurementRepository;
import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.CLIENTS)
public class ClientController {
    @Autowired
    public ClientService clientService;

    @Autowired
    public MeasurementRepository measurementRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Client createClient(@RequestBody Client client)
    {
        return this.clientService.create(client);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Client> findAll()
    {
        return this.clientService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client findClienById(@PathVariable Long id)
    {
        return this.clientService.findClientById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Client update(@PathVariable Long id, @RequestBody Client client)
    {
        return this.clientService.update(id, client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        this.clientService.delete(id);
    }

    //Relationships
    @RequestMapping(value = "/{id}/measuremnts", method = RequestMethod.GET)
    public List<Measurement> findMeasurementsByClient(Long id)
    {
        return this.clientService.findMeasurementsByClient(id);
    }
}


