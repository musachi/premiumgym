package com.premium.premiumgym.classification;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Classification} entity
 */
public class ClassificationDto implements Serializable {
    private Long id;
    private String name;
    private String description;

    private Long classificationCategory;

    public ClassificationDto() {
    }

    public ClassificationDto(Long id, String name, String description, Long classificationCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classificationCategory = classificationCategory;
    }

    public ClassificationDto(Classification classification)
    {
        if(classification != null)
        {
            this.id = classification.getId();
            this.name = classification.getName();
            this.description = classification.getDescription();
            this.classificationCategory = classification.getCategory().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public ClassificationDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClassificationDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassificationDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getClassificationCategory() {
        return classificationCategory;
    }

    public void setClassificationCategory(Long classificationCategory) {
        this.classificationCategory = classificationCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassificationDto entity = (ClassificationDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.classificationCategory, entity.classificationCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ")" +
                "classificationType = " + classificationCategory;
    }
}