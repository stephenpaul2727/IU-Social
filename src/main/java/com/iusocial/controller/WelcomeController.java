package com.iusocial.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
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
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	private PasswordEncoder passer = passwordEncoder();
	
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
    public String index(Model model,HttpSession session) {
        model.addAttribute("User", new User());
        return "index";
    }
	
	@RequestMapping(value = "/save", method=RequestMethod.POST )
	public String save(User user) {
		if(loginService.saveCheck(user)=="Valid Cred"){
			String pass = user.getPassword();
			user.setPassword(passer.encode(pass));
	    userInterface.save(user);}
		else {
			return "userexists";
		}
	    return "usersaved";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user,Model model,HttpSession session){
		if(loginService.loginCheck(user.getEmail(), user.getPassword())=="Valid User"){
			for(User newuser:userInterface.findAll()){
				if(newuser.getEmail().equals(user.getEmail())){
					model.addAttribute("User", newuser);
					session.setAttribute("UserLogged", newuser); 
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
	public String logout(Model model,HttpSession session){
		User user = new User();
		session.removeAttribute("UserLogged");
		model.addAttribute("User",user);
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value= "/post")
	public String Post(Model model,User user, Posts post){
		post.setUserofpost(user.getEmail());
		postInterface.save(post);
		model.addAttribute("User",user);
		return "postsuccess";
	
	}
	
	@RequestMapping(value="/sessionerror")
	public String SessionError(Model model){
		return "sessionexpired";
	}
	
	
}
