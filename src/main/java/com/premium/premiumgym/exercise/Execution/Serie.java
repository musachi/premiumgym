package com.premium.premiumgym.exercise.Execution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.premium.premiumgym.zconfig.ConstantValues;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id", nullable = false)
    private Long id;

    private int reps;

    private int executionOrder;

    @ManyToMany(mappedBy = "series",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnore
    private List<Execution> executions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(int executionOrder) {
        this.executionOrder = executionOrder;
    }

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    public void copy(Serie serieDetails) {
        this.reps = serieDetails.getReps();
        this.executionOrder = serieDetails.getExecutionOrder();
        if(serieDetails.getExecutions() != null)
        {
            this.executions = serieDetails.getExecutions();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        else if(Objects.equals(this, obj))
            return true;
        else if(this.getClass() != obj.getClass())
            return false;
        else
        {
            Serie serieObj = (Serie)obj;
            if(this.getReps() == serieObj.getReps() && this.getExecutionOrder() == serieObj.getExecutionOrder())
                return true;
            else
                return false;
        }
    }

    //TODO remove, just for test
    public static List<Serie> generateSeries()
    {
        List<Serie> series = new ArrayList<>();

        for(int i = 0, j = 1; i < 20; i++, j++)
        {
            int reps = ConstantValues.RANDOM.nextInt(ConstantValues.CHARACTERS.length());
            int executionOrder = j;

            Serie serie = new Serie();
            serie.setReps(reps);
            serie.setExecutionOrder(executionOrder);

            series.add(serie);

            if(j == 3)
                j = 0;
        }

        return series;
    }
}