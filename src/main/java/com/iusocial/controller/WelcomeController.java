package com.iusocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.iusocial.interfaces.UserInterface;
import com.iusocial.model.User;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserInterface userInterface;

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
}
