package com.premium.premiumgym.classification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.premium.premiumgym.zconfig.ConstantValues;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"category\"")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"category_id\"", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = ConstantValues.NAME_AND_DESCRIPTION_LENGTH, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Classification> classifications = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setId(Long id){ this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public void addClassification(Classification classification) {
        this.classifications.add(classification);
    }

    public void copy(Category newCategory) {
        this.setName(newCategory.getName());
        this.setClassifications(newCategory.getClassifications());
    }

    //TODO generate data
    public static List<Category> generateCategories()
    {
        String [] names = {"Movimiento", "Plano Muscular", "Implemento", "Posicion"};
        List<Category> categories = new ArrayList<>();
        for (String name : names)
        {
            Category category = new Category();
            category.setName(name);
            categories.add(category);
        }
        return categories;
    }
}