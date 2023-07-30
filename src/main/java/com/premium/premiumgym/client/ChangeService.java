package com.premium.premiumgym.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChangeService {

    @Autowired
    public ChangeRepository changeRepository;

    @Autowired
    public ClientRepository clientRepository;

    @Transactional
    public Change create(Long clientId, Change change){
        Client client = this.clientRepository.findById(clientId).get();
        change.setClient(client);

        return this.changeRepository.save(change);
    }

    //TODO better way to implement it and handle exception
    public Change findByChangeIdAndClientId(Long clientId, Long changeId)
    {
        Change change = this.changeRepository.findById(changeId).get();
        if(this.clientRepository.findById(clientId).get().getChanges().contains(change))
        {
            return change;
        }

        return new Change();
    }

    public List<Change> findByClient(Long clientId)
    {
        return this.changeRepository.findByClient(clientId);
    }

    //TODO better way to implement it and handle exception
    public Change update(Long clientId, Long changeId, Change changeDetails)
    {
        Change change = this.changeRepository.findById(changeId).get();
        if(this.clientRepository.findById(clientId).get().getChanges().contains(change))
        {
            change.copy(changeDetails);
            this.changeRepository.save(change);
        }

        return new Change();
    }

    //TODO better way to implement it and handle exception
    public void delete(Long clientId, Long changeId)
    {
        Change change = this.changeRepository.findById(changeId).get();
        if(this.clientRepository.findById(clientId).get().getChanges().contains(change))
            this.changeRepository.deleteById(changeId);
    }


}
