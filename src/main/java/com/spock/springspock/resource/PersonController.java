package com.spock.springspock.resource;

import com.spock.springspock.model.Person;
import com.spock.springspock.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService  personService;
    
    @GetMapping("/allpersons")
    public ResponseEntity<?> getAllUsers(){
       List<Person> userList= personService.getAllUser();
       ResponseEntity<?> responseEntity= new ResponseEntity<>(userList, HttpStatus.OK);
       return responseEntity;
    }

    @GetMapping("/findbypersonname/{name}")
    public  ResponseEntity<?> getPersonName(@PathVariable("name") String name){
        Person userList= personService.findByUsername(name);
       ResponseEntity<?> responseEntity= new ResponseEntity<>(userList,HttpStatus.OK);
       return responseEntity;
    }
    @GetMapping("/findbypersonid/{id}")
    public  ResponseEntity<?> getPersonById(@PathVariable("id") Integer id){
       Person userList= personService.findById(id);
       ResponseEntity<?> responseEntity= new ResponseEntity<>(userList,HttpStatus.OK);
       return responseEntity;
    }
}
