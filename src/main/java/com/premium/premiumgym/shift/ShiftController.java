package com.premium.premiumgym.shift;

import com.premium.premiumgym.client.Client;
import com.premium.premiumgym.zconfig.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConstantValues.SHIFTS)
public class ShiftController {

    @Autowired
    public ShiftService shiftService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Shift create(@RequestBody Shift shift){
        return this.shiftService.create(shift);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Shift> findAll(){
        return this.shiftService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Shift findShiftById(@PathVariable Long id) {
        return this.shiftService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Shift update(@PathVariable Long id, @RequestBody Shift newShift){
        return this.update(id, newShift);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.shiftService.delete(id);
    }

    @RequestMapping(value = "/{id}/clients", method = RequestMethod.GET)
    public List<Client> findClientsByShiftId(@PathVariable Long id)
    {
        return this.shiftService.findClientsByShiftId(id);
    }
}
