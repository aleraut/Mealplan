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
import ar.project.mealplan.domain.User;
import ar.project.mealplan.domain.UserRepository;

@SpringBootApplication
public class MealplanApplication {

	private static final Logger log = LoggerFactory.getLogger(MealplanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MealplanApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FoodRepository foodRepository, MealRepository mealRepository, UserRepository userRepository) {
		return (args) -> {

			// Create all meals
			mealRepository.save(new Meal("Breakfast"));
			mealRepository.save(new Meal("Lunch"));
			mealRepository.save(new Meal("Dinner"));
			mealRepository.save(new Meal("Snacks"));

			// Create a few example foods to FoodRepository
			foodRepository.save(new Food("Banana Cake", "Banana", 1200, 2.10, "Monday", mealRepository.findByName("Breakfast").get(0)));
			foodRepository.save(new Food("Lasagne", "Ground beef", 2400, 13.50, "Monday", mealRepository.findByName("Lunch").get(0)));
			foodRepository.save(new Food("Salad", "Lettuce", 200, 2.10, "Monday", mealRepository.findByName("Dinner").get(0)));
			foodRepository.save(new Food("Grapes", "Grape", 300, 1.50, "Monday", mealRepository.findByName("Snacks").get(0)));
			foodRepository.save(new Food("Chicken Wings", "Chicken", 1600.50, 4.50, "Tuesday", mealRepository.findByName("Dinner").get(0)));
			foodRepository.save(new Food("Tomato Soup", "Tomato", 745.20, 1.70, "Sunday", mealRepository.findByName("Lunch").get(0)));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

			// Logging to console
			log.info("fetch all foods");
			for (Food food : foodRepository.findAll()) {
				log.info(food.toString());
			}

		};
	}

}
