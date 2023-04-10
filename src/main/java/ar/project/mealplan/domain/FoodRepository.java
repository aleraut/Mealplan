package ar.project.mealplan.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long>{

    void deleteById(Long foodId);

    List<Food> findByName(String name);
    
}
