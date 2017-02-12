package com.iusocial.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

	@GetMapping("/greeting")
	public String Hello(){
		return "Welcome to IU Social Web Application developed as a course project for Software Engineering Spring 2017";
	}
}
