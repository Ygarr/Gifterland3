package gifterland3.controllers;

/**
 * Created by kdiv on 8/3/16.
 */
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
//import javax.naming.Reference;
import java.util.List;

@Controller
@RequestMapping("/")
public class FacebookController {

    /**
     *     Controller is created by injecting a Facebook object into its constructor.
     * The Facebook object is a reference to Spring Social’s Facebook API binding.
     */
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @Inject
    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "facebookFeed";
    }

    @RequestMapping("/friends_list")
    public String helloFacebookFriends(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
       // PagedList<Post> feed = facebook.feedOperations().getFeed();
       // List<FacebookProfile> friends = facebook.friendOperations().getFriendProfiles();
        //List<Reference> friends = facebook.friendOperations().getFriendLists();

        //Facebook also enables users to organize their friends into friend lists. To retrieve a list of the authenticating user's friend lists, call getFriendLists() with no arguments:

        PagedList<FriendList> friends = facebook.friendOperations().getFriendLists();

       // model.addAttribute("feed", feed);
        model.addAttribute("friends", friends);
        return "friends_list";
    }

}