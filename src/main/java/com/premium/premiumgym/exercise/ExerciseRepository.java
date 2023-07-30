package com.premium.premiumgym.exercise;

import com.premium.premiumgym.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExerciseRepository extends ListCrudRepository<Exercise, Long> {
    //public List<Exercise> findByTargetId(Long targetId);
}
