package gifterland3.controllers;

import gifterland3.models.Meal;
import gifterland3.models.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kdiv on 9/2/16.
 */
@Controller
public class MealController {

//    @Autowired
//    private ProductCategoryDao productCategoryDao;

    @Autowired
    private MealDao mealDao;

//    @Autowired
//    private FoodstoreDao foodstoreDao;

    @RequestMapping(value = "meal_descr", method = RequestMethod.GET)
    public String detailAllMeals(Model model) {
        //model.addAttribute("productcategories", productCategoryDao.findAll());
       // model.addAttribute("meals", mealDao.findAll());
       // model.addAttribute("foodstores", foodstoreDao.findAll());
        return "meal_descr"; //категории и товары неразделимы, поэтому сущность категории отображается в товарах

    }

    @RequestMapping(value = "meal_descr/detail/{mealId}", method = RequestMethod.GET)
    public String detailMeal(@PathVariable("mealId") Long mealId, Model model) {
        //model.addAttribute("productcategories", productCategoryDao.findAll());
       // Foodstore foodstore = foodstoreDao.findOne((long) foodstoreId);
        //Meal meals = mealDao.findByFoodstore(foodstore);
       // model.addAttribute("meals", foodstore.getMeals());
        //model.addAttribute("meals", mealDao.findByFoodstore(foodstore));
        Meal meal = mealDao.findOne(mealId);
        model.addAttribute("meal", meal);
        return "meal_descr";
    }

}
