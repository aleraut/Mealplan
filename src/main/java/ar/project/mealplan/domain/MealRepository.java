package ar.project.mealplan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Long> {
    
    List<Meal> findByName(String name);

}
