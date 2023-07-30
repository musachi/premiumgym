package com.premium.premiumgym.plan;

import com.premium.premiumgym.micro.Micro;
import jakarta.persistence.*;

@Entity
@Table(name = "\"PLAN_MICRO\"")
public class PlanMicro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_micro_id")
    private Long id;

    private Integer executionOrder;

    @ManyToOne
    @JoinColumn(name = "micro_id", nullable = false)
    private Micro micro;


    @ManyToOne
    @JoinColumn(name = "\"plan_id\"", nullable = false)
    private Plan plan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(Integer executionOrder) {
        this.executionOrder = executionOrder;
    }

    public Micro getMicro() {
        return micro;
    }

    public void setMicro(Micro micro) {
        this.micro = micro;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}