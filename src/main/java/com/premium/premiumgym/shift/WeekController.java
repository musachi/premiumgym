package com.premium.premiumgym.shift;

import com.premium.premiumgym.client.Client;
import com.premium.premiumgym.client.ClientService;
import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantValues.WEEKS)
public class WeekController {

    @Autowired
    public WeekService weekService;

    @Autowired
    public ClientService clientService;

    public Week create(Long clientId, Week week)
    {
        Client client = this.clientService.findClientById(clientId);

        week.setClient(client);
        Week newWeek = this.weekService.create(week);

        client.setWeek(newWeek);
        clientService.update(clientId, client);

        return newWeek;
    }

}
