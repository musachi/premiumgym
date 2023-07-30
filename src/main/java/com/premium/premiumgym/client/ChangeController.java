package com.premium.premiumgym.client;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.CHANGES)
public class ChangeController {

    @Autowired
    public ChangeService changeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Change create(@PathVariable(value = "id") Long clientId, @RequestBody Change change)
    {
        return this.changeService.create(clientId, change);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Change> findByClient(@PathVariable(value = "id") Long clientId)
    {
        return this.changeService.findByClient(clientId);
    }

    @RequestMapping(value = "/{changeId}", method = RequestMethod.GET)
    public Change findByChangeIdAndClientId(@PathVariable(value = "id") Long clientId, @PathVariable Long changeId)
    {
        return this.changeService.findByChangeIdAndClientId(clientId, changeId);
    }

    @RequestMapping(value = "/{changeId}", method = RequestMethod.PUT)
    public Change update(@PathVariable(value = "id") Long clientId, @PathVariable Long changeId, @RequestBody Change changeDetails)
    {
        return this.changeService.update(clientId, changeId, changeDetails);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long clientId, @PathVariable Long changeId)
    {
        this.changeService.delete(clientId, changeId);
    }
}
