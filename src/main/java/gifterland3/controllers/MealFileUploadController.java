package gifterland3.controllers;

import gifterland3.models.Meal;
import gifterland3.models.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Blob;


/**
 * Created by kdiv on 9/9/16.
 */
@Controller
public class MealFileUploadController {

    @Autowired
    private MealDao mealDao;


//    @RequestMapping(value = "meal_descr/detail/{mealId}", method = RequestMethod.POST)
    @PostMapping("meals/upload/{mealId}")
    public String handleMealUpdateWithFileUpload(@RequestParam("image") Blob file,
                                                 @RequestParam("mealId") long mealId) {

        Meal meal = mealDao.findOne(mealId);
        meal.setImage(file);
        mealDao.save(meal);

        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

       // return new ModelAndView("redirect:/meal_descr");
        return "redirect:/meals/upload";
    }



    //@GetMapping("/meal_descr/detail/{mealId}") //1.4.0 Style
    @RequestMapping(value = "meals/upload/{mealId}", method = RequestMethod.GET)
    public String listUploadedImage(@PathVariable("mealId") long mealId, Model model) throws IOException {
    // send it back to the client
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        model.addAttribute("meals", mealDao.findOne(mealId));

        return "meals/upload";//"uploadForm";
    }

}
