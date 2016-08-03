package gifterland3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class MainController {


//    @RequestMapping(value = {"/index", "/home", "/", }, method = RequestMethod.GET)
//    public String homePage() {
//
//        return "home";
//    }

//  @RequestMapping(value = {"/gifterland3","/index","/home","/main.html"},method = RequestMethod.GET)
//  @ResponseBody
//  public ModelAndView mainIndex() {  //was String ModelAndView
//      String message = "Proudly handcrafted by " +
//              "<a href='http://localhost:8080/'>localhost</a> :B";
// //     return  message;
//
////    return "Proudly handcrafted by " +
////        "<a href='http://localhost:8080/'>gifterland3</a> :)";
//      return new ModelAndView(message);
//  }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Here must be your login, " +
                "<a href='http://localhost:8080/'>someone</a> !!!";
    }


    @RequestMapping("/something")
    @ResponseBody
    public String helloWorld() {
        String now = (new Date()).toString();
        return "Sup! You! it is: " + now;
    }

    @RequestMapping(value ={"/reset","/login"})
    public String Reset() {
        return "redirect:/";
    }

    @RequestMapping("/main")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String messagHTML = "ModelAndView by " +
                "<a href='http://localhost:8080/'>localhost</a> :B";

        String messagThymeLeaf = "ModelAndView by  localhost :-B";

        //return new ModelAndView("/WEB-INF/views/main.html", "message", messaga);
        return new ModelAndView("main", "message", messagThymeLeaf);
    }

   //http://localhost:8080/greeting?name=User.
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
