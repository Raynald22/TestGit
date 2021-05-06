package com.ogya.reynaldi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ogya.reynaldi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
 
 User findByEmail(String email);
 //test2
}