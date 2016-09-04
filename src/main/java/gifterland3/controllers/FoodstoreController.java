package gifterland3.controllers;

import gifterland3.models.Foodstore;
import gifterland3.models.FoodstoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * A class to test interactions with the MySQL database using the FoodstoreDao class.
 *
 * @author borrowed
 */
@Controller
public class FoodstoreController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new user and save it in the database.
   * 
   * @param email Foodstore's email
   * @param name Foodstore's name
   * @return A string describing if the user is succesfully created or not.
   */
//  @RequestMapping(value={"/create","/spring-boot-mysql-springdatajpa-hibernate/templates/foodstore_shop_list.html"})
//  @ResponseBody
//  public String create(String email, String name) {
//      Foodstore foodservice = null;
//    try {
//        foodservice = new Foodstore(email, name);
//        foodserviceDao.save(foodservice);
//    }
//    catch (Exception ex) {
//      return "Error creating the user: " + ex.toString();
//    }
//    return "Foodstore succesfully created! (id = " + foodservice.getId() + ")";
//  }


//    @RequestMapping(value = "/createfoodservice", method = RequestMethod.POST)
//    public String addnewDivision(@ModelAttribute("foodservice") Foodstore foodservice, BindingResult result, Map<String, Object> map) {
//        map.put("foodservice", foodservice);
//        return "createfoodservice";//
//    }

//    @RequestMapping(value = "/foodservice_shop_list")
//    public String createFoodstore(String email, String name) {
//
//       Foodstore foodservice = new Foodstore(email, name);
//        foodserviceDao.save(foodservice);
//       // employeeService.addDivision(foodservice);
//        //return "redirect:/createfoodservice" +
//                return "classpath:resources/templates/foodstore_shop_list.html";
//    }

  /**
   * /delete  --> Delete the user having the passed id.
   * 
   * @param id The id of the user to delete
   * @return A string describing if the user is succesfully deleted or not.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Foodstore foodstore = new Foodstore(id);
        foodstoreDao.delete(foodstore);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "Foodstore succesfully deleted!";
  }
  
  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String foodserviceId;
    try {
      Foodstore foodstore = foodstoreDao.findByEmail(email);
        foodserviceId = String.valueOf(foodstore.getId());
    }
    catch (Exception ex) {
      return "Foodstore not found";
    }
    return "The user id is: " + foodserviceId;
  }
  
  /**
   * /update  --> Update the email and the name for the user in the database 
   * having the passed id.
   * 
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is succesfully updated or not.
   */
//  @RequestMapping("/update")
//  @ResponseBody
//  public String updateFoodstore(long id, String email, String name) {
//    try {
//      Foodstore foodstore = foodstoreDao.findOne(id);
//        foodstore.setEmail(email);
//        foodstore.setName(name);
//        foodstoreDao.save(foodstore);
//    }
//    catch (Exception ex) {
//      return "Error updating the user: " + ex.toString();
//    }
//    return "Foodstore succesfully updated!";
//  }

//    @RequestMapping(value = "/foodstores", method = RequestMethod.GET)
//    public String processFindForm(Foodstore foodstore, BindingResult result, Model model) {
//
//        // allow parameterless GET request for /owners to return all records
////        if (owner.getLastName() == null) {
////            owner.setLastName(""); // empty string signifies broadest possible search
////        }
//
//        // find owners by last name
//        String results = getByEmail((foodstore.getEmail()));
//        if (results.size() < 1) {
//            // no foodstore found (also in the beginning)
//            result.rejectValue("lastName", "notFound", "not found");
//            return "foodstores/foodstore_shop_list";
//        }
//       else if(results.size() > 1) {
//            // multiple owners found
//            model.addAttribute("selections", results);
//            return "foodstores/foodstore_shop_list";
//        }
//    }

    /**
     * Форма со списком
     *
     * @param map
     * @return ""
     */
    @RequestMapping("/foodstores")
    public String listFoodstores(Map<String, Object> map) {
        //map.put("foodtore", new Foodstore());
        map.put("foodstoresList", foodstoreDao.findAll());
        return "foodstores/foodstore_shop_list";
    }


    /**
     * Форма добавления нового
     *
     * @param
     * @param result
     * @param map
     * @return "addnewdivision"//not
     */
//    @RequestMapping(value = "/foodstores/new", method = RequestMethod.GET)
//    public String addFoodstoresForm(@ModelAttribute("foodstore") Foodstore foodstore, BindingResult result, Map<String, Object> map) {
//
//        map.put("foodstore", foodstore);
//        //public String initForm(Model model)
////        Foodstore ofoodstore = new Foodstore();
////        model.addAttribute(foodstore);
//        return "foodstores/createOrUpdateFoodstoreForm";//
//
//    }

    @RequestMapping(value="/foodstores/new", method = RequestMethod.GET)
    public String newProject() {
        //return "foodstores/new";
        return "foodstores/createOrUpdateFoodstoreForm";
    }

//    @RequestMapping(value = "/foodstores/create", method = RequestMethod.POST)
//    public ModelAndView create(@RequestParam("name") String name) {
//        foodstoreDao.save(new Foodstore("default@mail.com",name));
//        return new ModelAndView("redirect:/foodstores");
//    }

    /**
     * Добавление . Перенаправление .
     *
     * @param
     * @param
     * @return /
     */
    @RequestMapping(value = "/foodstores/create", method = RequestMethod.POST)
    public String addFoodstore(@ModelAttribute("foodstore") Foodstore foodstore, BindingResult result,Map<String, Object> map) {
        foodstoreDao.save(foodstore);
        return "redirect:/foodstores";
    }


  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private FoodstoreDao foodstoreDao;
  
} // class FoodstoreController
