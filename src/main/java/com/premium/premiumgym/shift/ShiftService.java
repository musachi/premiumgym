package com.premium.premiumgym.shift;

import com.premium.premiumgym.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {

    @Autowired
    public ShiftRepository shiftRepository;

    public Shift create(Shift shift){
        return shiftRepository.save(shift);
    }

    public List<Shift> findAll(){
        return this.shiftRepository.findAll();
    }

    public Shift findById(Long id)
    {
        return this.shiftRepository.findById(id).get();
    }

    public Shift update(Long id, Shift newShift){
        Shift shift = this.findById(id);
        shift.copy(newShift);

        return this.shiftRepository.save(shift);
    }
    
    public void delete(Long id){
        this.shiftRepository.deleteById(id);
    }

    public List<Client> findClientsByShiftId(Long shiftId)
    {
        return this.findById(shiftId).getClients();
    }
}
