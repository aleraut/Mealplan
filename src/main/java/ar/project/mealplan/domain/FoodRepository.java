package ar.project.mealplan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Repository for foods
public interface FoodRepository extends CrudRepository<Food, Long>{

    List<Food> findById(String foodId);

    void deleteById(Long foodId);

    List<Food> findByName(String name);

    Food findById(Food food);

    void deleteById(Food food);
    
}
