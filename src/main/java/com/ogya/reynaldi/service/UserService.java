package com.ogya.reynaldi.service;

import com.ogya.reynaldi.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}