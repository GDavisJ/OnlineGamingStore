package com.gamingstore.dao;

import java.util.List;

import com.gamingstore.models.User;

public interface UserDao {

  int register(User user);

  User validateUser(User user);
  
  boolean checkRegister(User user);
  
  List<User> getUsers();
}
