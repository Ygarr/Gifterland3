package gifterland3.controllers;

import gifterland3.models.Meal;
import gifterland3.models.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

/**
 * Created by kdiv on 9/2/16.
 */
@Controller
public class MealController {

//    @Autowired
//    private ProductCategoryDao productCategoryDao;

    @Autowired
    private MealDao mealDao;

    @Autowired
    private ServletContext servletContext;

//    @Autowired
//    private FoodstoreDao foodstoreDao;

    @RequestMapping(value = "meals/meal_descr", method = RequestMethod.GET)
    public String detailAllMeals(Model model) {
        //model.addAttribute("productcategories", productCategoryDao.findAll());
       // model.addAttribute("meals", mealDao.findAll());
       // model.addAttribute("foodstores", foodstoreDao.findAll());
        return "meals/meal_descr"; //категории и товары неразделимы, поэтому сущность категории отображается в товарах

    }

    @RequestMapping(value = "meals/meal_descr/detail/{mealId}", method = RequestMethod.GET)
    public String detailMeal(@PathVariable("mealId") Long mealId, Model model, HttpServletResponse response)  {

        Meal meal = mealDao.findOne(mealId);
        model.addAttribute("meal", meal);

        Blob image = meal.getImageBlob();
        byte[] imageReady;
        String base64Encoded;


        try {
            if (image != null) {
                long imageLength = image.length();
                imageReady = image.getBytes(1, Math.toIntExact(imageLength));
                base64Encoded = Base64.getEncoder().encodeToString(imageReady);
                model.addAttribute("media", base64Encoded);
            }
        } catch (SQLException e) {
            System.out.println("NO IMAGE");
        }


//            imageReady = null;
//            System.out.println("No image");



            //model.addAttribute("media", String.valueOf(encodedBytes));

//Resource imageReadyAsResource = new UrlResource(imageReady.toUri());
        //InputStream in = servletContext.
         // InputStream in = meal.getImageBlob().getBinaryStream();
        //response.setContentType(MediaType.IMAGE_JPEG_VALUE);
       // IOUtils.copy(in, response.getOutputStream());
        //BufferedImage img = ImageIO.read(meal.getImageBlob().getBinaryStream());

        return "meals/meal_descr";
    }

//    @RequestMapping("meals/meal_descr/detail/{mealId}")
//    public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable("mealId") Long mealId, ModelMap model) throws SQLException, IOException   {
//
//        Meal meal = mealDao.findOne(mealId);
//        Blob image = meal.getImageBlob();
//
//        HttpHeaders headers = new HttpHeaders();
//        InputStream in = meal.getImageBlob().getBinaryStream();
//        byte[] media = meal.getImageBlob().getBytes(1, (int) image.length());
//        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//        byte[] encodedBytes = java.util.Base64.getEncoder().encode(media); !!!!!!!!!!EncodeTo String!
//
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(encodedBytes, headers, HttpStatus.OK);
//        model.addAttribute("image", encodedBytes);
//        model.addAttribute("media", encodedBytes);
//        return null;
//    }

//    @PostMapping("meals/upload/{mealId}")
//    public void handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("mealId") long mealId,
//                                   RedirectAttributes redirectAttributes) {
//        //mealStorageService.store(file);
//        Meal meal = mealDao.findOne(mealId);
//        meal.setImageBlob(file);
//        mealDao.save(meal);
//       //      "You successfully uploaded " + file.getOriginalFilename() + "!");
//       // return "redirect:/meals/upload/{mealId}";
//    }

}
