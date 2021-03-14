package com.gamingstore.services;


import com.gamingstore.models.User;

public interface UserService {

  int register(User user);

  User validateUser(User user);
  
  boolean  checkRegister(User user);
  
}
