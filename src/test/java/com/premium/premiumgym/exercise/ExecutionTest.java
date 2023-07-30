package com.premium.premiumgym.exercise;

import com.premium.premiumgym.exercise.Execution.Execution;
import com.premium.premiumgym.exercise.Execution.ExecutionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ExecutionTest {
    @Autowired
    private ExecutionRepository repo;

    @Test
    public void saveNew()
    {
        for (Execution e : Execution.generateExecution()){
            repo.save(e);
        }
    }


}
