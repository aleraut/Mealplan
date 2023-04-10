package ar.project.mealplan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.project.mealplan.domain.MealRepository;

@Controller
public class MealController {
    
    @Autowired
    MealRepository mealRepository;

    @RequestMapping("/meallist")
    public String mealList(Model model) {

        model.addAttribute("meals", mealRepository.findAll());

        return "meallist";
    }

}
