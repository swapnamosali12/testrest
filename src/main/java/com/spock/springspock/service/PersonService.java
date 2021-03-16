package com.spock.springspock.service;

import com.spock.springspock.model.Person;
import com.spock.springspock.model.User;
import com.spock.springspock.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    public PersonRepository personRepository;
    public java.util.List<Person> getAllUser(){
        return personRepository.findAll();
    }
    public Person findByUsername(String name){
        return personRepository.findByUserName(name);
    }
    public Person findById(Integer id){
        return personRepository.findById(id).orElse(null);
    }

}
