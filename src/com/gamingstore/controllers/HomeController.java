package com.gamingstore.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**This is the home controller used for mapping to the home page*/
@Controller
public class HomeController {
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**Method used to map to the home page if "/" is used for the link*/
	@RequestMapping("/")
	public ModelAndView home()
	{
		logger.info("Entering and Leaving HomeController.home");
		return new ModelAndView("home");
		
	}
	
	/**Method used to map to the home page if "/home" is used as the link*/
	@RequestMapping("/home")
	public ModelAndView homeMap()
	{
		logger.info("Entering and Leaving HomeController.homeMap");
		return new ModelAndView("home");
		
	}
}
