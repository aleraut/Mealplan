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
    private String type;
    private String origin;
    private double price;

    // Joining Food table to Meal table
    @ManyToOne
    @JoinColumn(name = "mealId")
    private Meal meal;

    
    public Food(){}

    // Constructor
    public Food(String name, String type, String origin, double price, Meal meal){
        super();
        this.name = name;
        this.type = type;
        this.origin = origin;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

        return "Food [id =" + id + ", name =" + name + ", type =" + type + ", origin =" + origin + ", price =" + price + ", meal=" + this.getMeal() + "]";

        else

        return "Food [id =" + id + ", name =" + name + ", type =" + type + ", origin =" + origin + ", price =" + price + "]";
    }
}
