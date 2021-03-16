package com.spock.springspock.resource;

import com.spock.springspock.model.User;
import com.spock.springspock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
   private UserService userService;
    UserController (UserService userService){
     this.userService=userService;
    }
    @GetMapping("/")
    public ResponseEntity<?> test() {
        return new ResponseEntity("Hello world!", HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public  ResponseEntity<?> getAllUsers(){
       List<User> userList= userService.getAllUser();
       ResponseEntity<?> responseEntity= new ResponseEntity<>(userList,HttpStatus.OK);
       return responseEntity;
    }

    @GetMapping("/findbyusername/{name}")
    public  ResponseEntity<?> getUserName(@PathVariable("name") String name){
       User userList= userService.findByUsername(name);
       ResponseEntity<?> responseEntity= new ResponseEntity<>(userList,HttpStatus.OK);
       return responseEntity;
    }
    @GetMapping("/findbyid/{id}")
    public  ResponseEntity<?> getUserId(@PathVariable("id") Integer id){
       User userList= userService.findById(id);
       ResponseEntity<?> responseEntity= new ResponseEntity<>(userList,HttpStatus.OK);
       return responseEntity;
    }

}