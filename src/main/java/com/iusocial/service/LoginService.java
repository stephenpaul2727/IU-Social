package com.iusocial.service;


import org.springframework.stereotype.Service;
import com.iusocial.interfaces.UserInterface;
import com.iusocial.model.User;

@Service
public class LoginService {

private final UserInterface userInterface;
	
	public LoginService(UserInterface userInterface)
	{
		this.userInterface = userInterface;
	}

	public String loginCheck(String email, String password){
	
		for(User user:userInterface.findAll())
		{
			if(user.getEmail().equals(email)&&user.getPassword().equals(password))
			{
				return "Valid User";
			}
		}
		return "User doesn't exist!";
	}
}
