package com.gamingstore.controllers;

import javax.validation.Valid;

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
public class RegistrationController {
	//inject the user service
	@Autowired
	public UserService userService;
	
	//used to GET the registration page based on user request
	@RequestMapping(path = "/registration", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("registration", "user", new User());
	}
	
	//method is called once the reg form is submitted (POST).
	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());

		//verify the form doesn't have errors and if it does, return to reg page with errors.
		if (result.hasErrors()) {
		  
			return new ModelAndView("registration", "user", user);
		}
		
		//No form errors found.
		else {
			/*verify the username doesn't already exist and if it doesn't register the user, 
			 * else return an error notifying the user.
			 */
			boolean check = userService.checkRegister(user);
			if(check == false)
			{
				userService.register(user);
			}
			else
			{
				  result.rejectValue("username", "error.user", "The User already exists");
				  return new ModelAndView("registration", "user", user);
			}
			
			return new ModelAndView("login", "user", new User());
		}
		
	}
	
}
