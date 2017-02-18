package com.iusocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.iusocial.interfaces.UserInterface;
import com.iusocial.model.User;
import com.iusocial.service.LoginService;

@Controller
public class WelcomeController {
	
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
	public String login(User user){
		if(loginService.loginCheck(user.getEmail(), user.getPassword())=="Valid User"){
			return "profile";
		}
		else{
			return "incorrectuser";
		}
		
	}
}
