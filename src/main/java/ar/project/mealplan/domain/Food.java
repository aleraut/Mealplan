package ar.project.mealplan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ingredient;
    private double calories;
    private double price;
    private String paiva;

    // Joining Food table to Meal table
    @ManyToOne
    @JoinColumn(name = "mealId")
    private Meal meal;

    
    public Food(){}

    // Constructor
    public Food(String name, String ingredient, double calories, double price, String paiva, Meal meal){
        super();
        this.name = name;
        this.ingredient = ingredient;
        this.calories = calories;
        this.price = price;
        this.paiva = paiva;
        this.meal = meal;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaiva() {
        return paiva;
    }

    public void setPaiva(String paiva) {
        this.paiva = paiva;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Override
    public String toString() {

        if(this.meal != null)

        return "Food [id =" + id + ", name =" + name + ", ingredient =" + ingredient + ", calories =" + calories + ", price =" + price + ", paiva =" + paiva + ", meal=" + this.getMeal() + "]";

        else

        return "Food [id =" + id + ", name =" + name + ", ingredient =" + ingredient + ", calories =" + calories + ", price =" + price + ", paiva =" + paiva + "]";
    }
}
