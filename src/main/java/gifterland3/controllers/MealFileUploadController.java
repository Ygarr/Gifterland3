package gifterland3.controllers;

import gifterland3.models.Meal;
import gifterland3.models.MealDao;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;


/**
 * Created by kdiv on 9/9/16.
 */
@Controller
public class MealFileUploadController {

    @Autowired
    private MealDao mealDao;

    //@PostMapping("meals/upload/{mealId}")
    @RequestMapping(value = "meals/upload/{mealId}", method = RequestMethod.POST)
    public void handleMealUpdateWithFileUpload(@RequestParam("image") MultipartFile file,
                                               @RequestParam("imageName") String name,
                                               @RequestParam("mealId") long mealId, SessionFactory sessionFactory) throws IOException {


        Meal meal = mealDao.findOne(mealId);

        Blob fileBlob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(file.getInputStream(),file.getSize());


        meal.setImageBlob(fileBlob);
        mealDao.save(meal);

//        System.out.println(file.getOriginalFilename()); // It works so I receive the MultipartFile correctly.
//        //System.out.println(sessionFactory); // It works, so SessionFactory is not null
//
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//
//                file.getInputStream();
//
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name
//                    + " because the file was empty.";
//        }

        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

       // return new ModelAndView("redirect:/meal_descr");
        //return "redirect:/meals/upload";
    }



//    //@GetMapping("/meal_descr/detail/{mealId}") //1.4.0 Style
    @RequestMapping(value = "meals/upload/{mealId}", method = RequestMethod.GET)
    public String listUploadedImage(@PathVariable("mealId") long mealId, Model model) throws IOException, SQLException {

        Meal mealWithImage = mealDao.findOne(mealId);
        //Execute SET  image = FILE_READ('~/icecream_obama_5Y8EIxwG_WU.jpg') WHERE ID=4; --for debug
        model.addAttribute("image", mealWithImage.getImageBlob());
        return "meals/upload";//return name of html view with thymeleaf
        //REsult:
        // blob8: CAST(REPEAT('00', 75618) AS BINARY /* table: -3 id: 8 */)
        //

    }

}
