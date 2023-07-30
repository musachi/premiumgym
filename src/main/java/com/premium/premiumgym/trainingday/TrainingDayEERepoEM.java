package com.premium.premiumgym.trainingday;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingDayEERepoEM {
    @PersistenceContext
    private EntityManager entityManager;

    public List<TrainingDayEE> findByTrainingDayId(Long trainingDayId) {
        TypedQuery<TrainingDayEE> query = entityManager.createNamedQuery("TrainingDayEE.findByTrainingDayI", TrainingDayEE.class);
        query.setParameter("trainingDayId", trainingDayId);
        return query.getResultList();
    }
}
