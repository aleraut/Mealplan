package ar.project.mealplan.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String name;

    // Joining list of foods to meal table
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meal")
    private List<Food> foods;

    public Meal(){}

    public Meal(String name) {
        super();
        this.name = name;
    }

    // Getters and Setters
    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Meal [mealId =" + mealId + ", name =" + name + "]";
    }
}
