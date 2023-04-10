package ar.project.mealplan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.project.mealplan.domain.FoodRepository;

@Controller
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    // Show all foods
    @RequestMapping(value={"/", "foodlist"})
        public String foodList(Model model) {

            model.addAttribute("foods", foodRepository.findAll());

            return "foodlist";

        }
    
}
