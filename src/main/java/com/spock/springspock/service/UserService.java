package com.spock.springspock.service;

import com.spock.springspock.model.User;
import com.spock.springspock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    UserRepository userRepository;
    UserService(UserRepository userRepository){
this.userRepository=userRepository;
    }
   public java.util.List<User> getAllUser(){
       return userRepository.findAll();
    }
   public User findByUsername(String name){
      return userRepository.findByUserName(name);
   }
   public User findById(Integer id){
       return userRepository.findById(id).orElse(null);
   }

}
