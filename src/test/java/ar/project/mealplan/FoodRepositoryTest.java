package ar.project.mealplan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ar.project.mealplan.domain.Food;
import ar.project.mealplan.domain.FoodRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FoodRepositoryTest {
    
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private TestEntityManager em;

    @Test // Testing find by name from foodrepository
	public void findByTitleShouldReturnTitle() {
		List<Food> foods =foodRepository.findByName("Lasagne");
		
		assertThat(foods).hasSize(1);
		assertThat(foods.get(0).getIngredient()).isEqualTo("Ground beef");
	}

    @Test // Testing foodrepository save method
	public void createNewFood() {
		Food food = new Food("Curry", "Chicken", 2020.20, 11, "Thursday", null);
		foodRepository.save(food); // sql-insert
		assertThat(food.getId()).isNotNull();
	}

    @Test // Testing foodrepository delete method
	public void DeleteFoodTest() {
		Food food = new Food("Curry", "Chicken", 2020.20, 11, "Thursday", null);
		final Long id = em.persistAndGetId(food, Long.class);
        foodRepository.deleteById(id);
        em.flush();
        Food after = em.find(Food.class, id);
		foodRepository.deleteById(food.getId());
		assertThat(after).isNull();
	}

}
