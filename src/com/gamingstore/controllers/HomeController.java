package com.gamingstore.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public ModelAndView home()
	{
		logger.info("Entering and Leaving HomeController.home");
		return new ModelAndView("home");
		
	}
	
	@RequestMapping("/home")
	public ModelAndView homeMap()
	{
		logger.info("Entering and Leaving HomeController.homeMap");
		return new ModelAndView("home");
		
	}
}
