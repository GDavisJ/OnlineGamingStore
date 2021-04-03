package com.gamingstore.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamingstore.dao.UserDao;
import com.gamingstore.models.User;

@RestController()
@RequestMapping("/service")
public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;
  private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


  public int register(User user) {
		logger.info("Entering and Leaving UserServiceImpl.register");
    return userDao.register(user);
  }
  /*
   * Method to validate user from DAO
   * 
   */
  public User validateUser(User user) {
		logger.info("Entering and Leaving UserServiceImpl.validateUser");
    return userDao.validateUser(user);
  }
   /*
    * Method to return DAO after checking if user is already registered
    * 
    */
public boolean checkRegister(User user) {
	logger.info("Entering and Leaving UserServiceImpl.checkRegister");
	return userDao.checkRegister(user);
}

//Get a list of users from the database
@GetMapping("/users")
public List<User> getUsers(){
	logger.info("Entering and Leaving UserServiceImpl.getUsers");
	return userDao.getUsers();
}

}
