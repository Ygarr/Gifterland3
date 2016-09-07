package gifterland3.controllers;

import gifterland3.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kdiv on 8/20/16.
 */
@Controller
@RequestMapping("/foodstores/productcategories")
public class ProductCategoriesController {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private MealDao mealDao;

    @Autowired
    private FoodstoreDao foodstoreDao;

    @RequestMapping(value = "foodstore_shop_meal_list", method = RequestMethod.GET)
    public String listAllMeals(Model model) {
        model.addAttribute("productcategories", productCategoryDao.findAll());
        model.addAttribute("meals", mealDao.findAll());
        model.addAttribute("foodstores", foodstoreDao.findAll());
        return "foodstores/productcategories/foodstore_shop_meal_list"; //категории и товары неразделимы, поэтому сущность категории отображается в товарах

    }

    @RequestMapping(value = "foodstore_shop_meal_list/detail/{foodstoreId}", method = RequestMethod.GET)
    public String listMeals(@PathVariable("foodstoreId") int foodstoreId, Model model) {
        model.addAttribute("productcategories", productCategoryDao.findAll());
        Foodstore foodstore = foodstoreDao.findOne((long) foodstoreId);
        //Meal meals = mealDao.findByFoodstore(foodstore);
        model.addAttribute("meals", foodstore.getMeals());
        //model.addAttribute("meals", mealDao.findByFoodstore(foodstore));
        return "foodstores/productcategories/foodstore_shop_meal_list";
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "foodstores/productcategories/new";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("name") String productcategory) {
        productCategoryDao.save(new ProductCategory(productcategory));
        return new ModelAndView("redirect:/foodstores/productcategories/foodstore_shop_meal_list");
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        productCategoryDao.delete(id);
        return new ModelAndView("redirect:/foodstores/productcategories/foodstore_shop_meal_list");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("productcategory_id") long id,
                               @RequestParam("name") String name) {
        ProductCategory productCategory = productCategoryDao.findOne(id);
        productCategory.setName(name);
        productCategoryDao.save(productCategory);
        return new ModelAndView("redirect:/foodstores/productcategories/foodstore_shop_meal_list");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model) {
        ProductCategory productCategory = productCategoryDao.findOne(id);
        model.addAttribute("productCategory", productCategory);
        return "foodstores/productcategories/edit";
    }
}
