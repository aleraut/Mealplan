package ar.project.mealplan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.project.mealplan.domain.Food;
import ar.project.mealplan.domain.FoodRepository;
import ar.project.mealplan.domain.Meal;
import ar.project.mealplan.domain.MealRepository;

@SpringBootApplication
public class MealplanApplication {

	private static final Logger log = LoggerFactory.getLogger(MealplanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MealplanApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FoodRepository foodRepository, MealRepository mealRepository) {
		return (args) -> {

			// Create all meals
			mealRepository.save(new Meal("Breakfast"));
			mealRepository.save(new Meal("Lunch"));
			mealRepository.save(new Meal("Dinner"));
			mealRepository.save(new Meal("Snacks"));

			// Create a few example foods to FoodRepository
			foodRepository.save(new Food("Banana", "Fruit", "Asia", 2.10, mealRepository.findByName("Breakfast").get(0)));
			foodRepository.save(new Food("Chicken", "Meat", "Europe", 4.50, mealRepository.findByName("Dinner").get(0)));
			foodRepository.save(new Food("Tomato", "Vegetable", "Europe", 1.70, mealRepository.findByName("Lunch").get(0)));

			// Logging to console
			log.info("fetch all foods");
			for (Food food : foodRepository.findAll()) {
				log.info(food.toString());
			}

		};
	}

}
