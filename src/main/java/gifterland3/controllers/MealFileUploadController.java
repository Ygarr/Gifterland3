package gifterland3.controllers;

import gifterland3.models.Meal;
import gifterland3.models.MealDao;
import gifterland3.service.MealStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;


/**
 * Created by kdiv on 9/9/16.
 */
@Controller
public class MealFileUploadController {

    private final MealStorageService mealStorageService;

    @Autowired
    public MealFileUploadController(MealStorageService mealStorageService) {
        this.mealStorageService = mealStorageService;
    }

    @Autowired
    private MealDao mealDao;

//    @Autowired
//    private MealDao mealDao;
//
//    @Autowired
//    private Meal meal;


    //@PostMapping("meals/upload/{mealId}")
//    @RequestMapping(value = "meals/upload/{mealId}", method = RequestMethod.POST)
//    public void handleMealUpdateWithFileUpload(@RequestParam("image") MultipartFile file,
//                                               @RequestParam("imageName") String name,
//                                               @RequestParam("mealId") long mealId, SessionFactory sessionFactory) throws IOException {
//
//
//        Meal meal = mealDao.findOne(mealId);
//
////        Blob fileBlob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(file.getInputStream(),file.getSize());
////        meal.setImageBlob(fileBlob);
////        mealDao.save(meal);
//
////        System.out.println(file.getOriginalFilename()); // It works so I receive the MultipartFile correctly.
////        //System.out.println(sessionFactory); // It works, so SessionFactory is not null
////
////        if (!file.isEmpty()) {
////            try {
////                byte[] bytes = file.getBytes();
////
////                file.getInputStream();
////
////            } catch (Exception e) {
////                return "You failed to upload " + name + " => " + e.getMessage();
////            }
////        } else {
////            return "You failed to upload " + name
////                    + " because the file was empty.";
////        }
//
//        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//       // return new ModelAndView("redirect:/meal_descr");
//        //return "redirect:/meals/upload";
//    }



////    //@GetMapping("/meal_descr/detail/{mealId}") //1.4.0 Style
//    @RequestMapping(value = "meals/upload/{mealId}", method = RequestMethod.GET)
//    public String listUploadedImage(@PathVariable("mealId") long mealId, Model model, HttpServletResponse resp) throws IOException, SQLException {
//
//        resp.setContentType("image/jpeg");
//
//        Meal mealWithImage = mealDao.findOne(mealId);
//        //Execute: update MEAL SET  image = FILE_READ('~/icecream.jpg') WHERE ID=4;; --for debug
//        model.addAttribute("image", mealWithImage.getImageBlob());
//        Blob imageBlob = mealWithImage.getImageBlob();
//        resp.setContentLength((int) imageBlob.length());
//        InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
////        resp.getOutputStream().write(binaryStream.read());
////        Streams.copy(binaryStream, resp.getOutputStream(), true);
//       // model.addAttribute("image", binaryStream);
//
//        return "meals/upload";//return name of html view with thymeleaf
//        //REsult:
//        // blob8: CAST(REPEAT('00', 75618) AS BINARY /* table: -3 id: 8 */)
//        //
//
//    }


//    @RequestMapping(value = "meals/upload/{mealId}", headers = "Accept=image/jpeg, image/jpg, image/png, image/gif", method = RequestMethod.GET)
//    public @ResponseBody byte[] getImage(@PathVariable("mealId") long mealId) throws SQLException, IOException {
//        Meal mealWithImage = mealDao.findOne(mealId);
//       // Blob imageBlob = mealWithImage.getImageBlob();
//
//
//            Blob imageBlob = mealWithImage.getImageBlob();
//           // InputStream in = new ByteArrayInputStream(mealWithImage.getAttachmentFile());
//            InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
//            BufferedImage img = ImageIO.read(binaryStream);
//
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Meal imgNew =  (Meal)session.get(Meal.class, 1);
//
//byte[] bAvatar = img.getData();
//
//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        ImageIO.write(img, "jpg", bao);
//        return bao.toByteArray();
//
//    }





    @GetMapping("meals/upload/{mealId}")
    public String listUploadedFiles(Model model) throws IOException, SQLException {
        model.addAttribute("files", mealStorageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(MealFileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));
        //model.addAttribute("meal",meal);

        return "meals/upload";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = mealStorageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }


    @PostMapping("meals/upload/{mealId}")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        mealStorageService.store(file);
//        Meal meal = mealDao.findOne(mealId);
//        meal.setImageBlob(file);
//        mealDao.save(meal);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/meals/upload/{mealId}";
    }
}
