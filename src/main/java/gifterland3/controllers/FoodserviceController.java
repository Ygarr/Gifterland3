package gifterland3.controllers;

import gifterland3.models.Foodservice;
import gifterland3.models.FoodserviceDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the FoodserviceDao class.
 *
 * @author borrowed
 */
@Controller
public class FoodserviceController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new user and save it in the database.
   * 
   * @param email Foodservice's email
   * @param name Foodservice's name
   * @return A string describing if the user is succesfully created or not.
   */
  @RequestMapping("/create")
  @ResponseBody
  public String create(String email, String name) {
      Foodservice foodservice = null;
    try {
        foodservice = new Foodservice(email, name);
        foodserviceDao.save(foodservice);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Foodservice succesfully created! (id = " + foodservice.getId() + ")";
  }
  
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
      Foodservice foodservice = new Foodservice(id);
        foodserviceDao.delete(foodservice);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "Foodservice succesfully deleted!";
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
      Foodservice foodservice = foodserviceDao.findByEmail(email);
        foodserviceId = String.valueOf(foodservice.getId());
    }
    catch (Exception ex) {
      return "Foodservice not found";
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
  @RequestMapping("/update")
  @ResponseBody
  public String updateFoodservice(long id, String email, String name) {
    try {
      Foodservice foodservice = foodserviceDao.findOne(id);
        foodservice.setEmail(email);
        foodservice.setName(name);
        foodserviceDao.save(foodservice);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "Foodservice succesfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private FoodserviceDao foodserviceDao;
  
} // class FoodserviceController
