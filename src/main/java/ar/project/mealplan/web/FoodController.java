package ar.project.mealplan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.project.mealplan.domain.Food;
import ar.project.mealplan.domain.FoodRepository;
import ar.project.mealplan.domain.MealRepository;

@Controller
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private MealRepository mealRepository;

    // login
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    // Show all foods
    @RequestMapping(value={"/", "foodlist"})
        public String foodList(Model model) {

            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String username = user.getUsername();
		    System.out.println("USERNAME: " + username);

            model.addAttribute("foods", foodRepository.findAll());
            model.addAttribute("meals", mealRepository.findAll());

            return "foodlist";

        }

    // Add a food
    @RequestMapping(value = "/add")
    public String addFood(Model model) {

        model.addAttribute("food", new Food());
        model.addAttribute("meals", mealRepository.findAll());

        return "addfood";
    }

    // Save a food
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFood(Food food) {
        
        foodRepository.save(food);

        return "redirect:foodlist";
    }

    // Delete a food
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFood(@PathVariable("id") Long foodId, Model model) {

        foodRepository.deleteById(foodId);

        return "redirect:/foodlist";
    }

    // Edit a food
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long foodId, Model model) {

        model.addAttribute("food", foodRepository.findById(foodId));
        model.addAttribute("meals", mealRepository.findAll());

        return "editfood";
    }
    
}
