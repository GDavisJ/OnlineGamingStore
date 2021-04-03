package com.gamingstore.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gamingstore.models.User;
import com.gamingstore.services.UserService;

@Controller
public class UserController {
	// Call the user business service
	@Autowired
	UserService userService;
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	/*
	 * Method to display login pag
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		logger.info("Entering and Leaving UserController.displayForm");
		return new ModelAndView("login", "user", new User());
	}
	/*
	 * Method to process login attempt
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		logger.info("Entering UserController.loginUser");
		// print username and password in console
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		// validate user in business service and DAO
		User userVal = userService.validateUser(user);
        // if validation errors return login page
		if (result.hasFieldErrors("username") || result.hasFieldErrors("password")) {
			logger.info("Leaving UserController.loginUser");
			return new ModelAndView("login", "user", user);
		}
        // if the user is returned from DAO return welcome page
		else if (null != userVal) {
			logger.info("Leaving UserController.loginUser");
			return new ModelAndView("loginMessage", "message", "Welcome " + user.getUsername()+"!");
		}

		//This is temp (used for testing)
		/*else if(user.getUsername().matches("gdavis") && user.getPassword().matches("1234")) {
			return new ModelAndView("loginMessage", "message", "Welcome " + user.getUsername()+"!");
		}*/
		// if user is not returned from DAO, login failed message
		else {
			logger.info("Leaving UserController.loginUser");
			return new ModelAndView("loginMessage", "message", "Login Failed!");
		}
		
	}
	
	//Used to display the table of users (uses jQuery to create the table)
	@RequestMapping("/users")
	public ModelAndView getUsers(){
		logger.info("Entering and Leaving UserController.getUsers");
		return new ModelAndView("displayUsers");
		
	}
	
}
