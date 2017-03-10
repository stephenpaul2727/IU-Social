package com.iusocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.iusocial.interfaces.PagesInterface;
import com.iusocial.interfaces.PostInterface;
import com.iusocial.interfaces.UserInterface;
import com.iusocial.interfaces.UserinfoInterface;
import com.iusocial.model.Posts;
import com.iusocial.model.User;
import com.iusocial.service.LoginService;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserinfoInterface userinfoInterface;
	
	@Autowired
	private PostInterface postInterface;
	
	@Autowired
	private PagesInterface pagesInterface;
	
	@Autowired
	private UserInterface userInterface;
	@Autowired
	private LoginService loginService;
	
	

	@RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("User", new User());
        return "index";
    }
	
	@RequestMapping(value = "/save", method=RequestMethod.POST )
	public String save(User user) {
	    userInterface.save(user);
	    return "usersaved";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user,Model model){
		if(loginService.loginCheck(user.getEmail(), user.getPassword())=="Valid User"){
			for(User newuser:userInterface.findAll()){
				if(newuser.getEmail().equals(user.getEmail())){
					model.addAttribute("User", newuser);
			}}
			for(Posts newpost:postInterface.findAll()){
				if(newpost.getUserofpost().equals(user.getEmail())){
					model.addAttribute("Post",newpost);
					return "profile";
				}
			}
			model.addAttribute("Post", new Posts());
			return "profile";
		}
		else{
			return "incorrectuser";
		}
		
	}
	
	@RequestMapping(value= "/logout")
	public String logout(Model model){
		User user = new User();
		model.addAttribute("User",user);
		return "index";
	}
	
	@RequestMapping(value= "/post")
	public String Post(Model model,User user, Posts post){
		post.setUserofpost(user.getEmail());
		postInterface.save(post);
		model.addAttribute("User",user);
		return "postsuccess";
	
	}
	
	
	
}
