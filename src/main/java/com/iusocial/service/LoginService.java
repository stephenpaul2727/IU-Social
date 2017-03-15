package com.iusocial.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.iusocial.interfaces.UserInterface;
import com.iusocial.model.User;

@Service
public class LoginService {
	
	
	@Bean
	public PasswordEncoder pEncoder() {
	    return new BCryptPasswordEncoder();
	}
	private PasswordEncoder penc  = pEncoder();



private final UserInterface userInterface;
	
	public LoginService(UserInterface userInterface)
	{
		this.userInterface = userInterface;
	}

	public String loginCheck(String email, String password){
	
		for(User user:userInterface.findAll())
		{
			if(user.getEmail().equals(email)&&penc.matches(password, user.getPassword()))
			{
				return "Valid User";
			}
		}
		return "User doesn't exist!";
	}
	
	public String saveCheck(User userref){
		for(User user:userInterface.findAll()){
			if(user.getEmail().equals(userref.getEmail())){
				return "User Exists";
				}
			else{
				return "Valid Cred";
				}
			}
		return null;
	}
	
}

