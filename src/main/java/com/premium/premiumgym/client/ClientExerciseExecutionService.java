package com.premium.premiumgym.client;

import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecution;
import com.premium.premiumgym.exercise.ExerciseExecution.ExerciseExecutionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientExerciseExecutionService {

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public ExerciseExecutionRepository exerciseExecutionRepository;

    @Autowired
    public ClientExerciseExecutionRepository clientExerciseExecutionRepository;

    @Transactional
    public void addExerciseExecutionToClient(ClientExerciseExecutionDto clientExerciseExecutionDto)
    {
        Client client = this.clientRepository.findById(clientExerciseExecutionDto.getClientId()).get();
        ExerciseExecution exerciseExecution = this.exerciseExecutionRepository.findById(clientExerciseExecutionDto.getExerciseExecutionId()).get();

        ClientExerciseExecution clientExerciseExecution = new ClientExerciseExecution();
        clientExerciseExecution.attrFromClientExerciseExecutionDto(clientExerciseExecutionDto);
        clientExerciseExecution.setExerciseExecution(exerciseExecution);
        clientExerciseExecution.setClient(client);

        client.addExerciseExecution(clientExerciseExecution);
        exerciseExecution.addCient(clientExerciseExecution);

        clientRepository.save(client);
        exerciseExecutionRepository.save(exerciseExecution);
    }

    public void removeExerciseExecutionToClient(Long clientId,  Long exerciseExecutionId)
    {
        Client client = this.clientRepository.findById(clientId).get();
        ExerciseExecution exerciseExecution = this.exerciseExecutionRepository.findById(exerciseExecutionId).get();

        ClientExerciseExecution clientExerciseExecution = clientExerciseExecutionRepository.findByClientAndExerciseExecution(clientId, exerciseExecutionId);
        this.clientExerciseExecutionRepository.deleteById(clientExerciseExecution.getId());


        client.removeExerciseExecution(clientExerciseExecution);
        exerciseExecution.removeCient(clientExerciseExecution);

        clientRepository.save(client);
        exerciseExecutionRepository.save(exerciseExecution);
    }
}
