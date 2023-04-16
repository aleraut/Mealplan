package ar.project.mealplan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ar.project.mealplan.web.FoodController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MealplanApplicationTests {

	@Autowired
	private FoodController foodController;

	@Test
	void contextLoads()throws Exception {
		assertThat(foodController).isNotNull();
	}

}
