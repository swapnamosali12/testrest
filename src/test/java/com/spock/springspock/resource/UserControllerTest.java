package com.spock.springspock.resource;


import com.spock.springspock.model.User;
import com.spock.springspock.model.User;
import com.spock.springspock.repository.UserRepository;
import com.spock.springspock.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;

    @Test
    public void getUserByName() {
        when(userService.findByUsername(any())).thenReturn(new User("test", 8, 9,"user","user@gmail.com"));
        ResponseEntity<?> user = userController.getUserName("cc");
        assertNotNull(user);
        assertEquals(200, user.getStatusCodeValue());
        User resultUser = (User) user.getBody();
        assertEquals("test", resultUser.getUserName());
    }

    @Test
    public void getUserById() {
        when(userService.findById(any())).thenReturn(new User("test", 8, 9,"user","user@gmail.com"));
        ResponseEntity<?> user = userController.getUserId(3);
        assertNotNull(user);
        assertEquals(200, user.getStatusCodeValue());
        User resultUser = (User) user.getBody();
        assertEquals(8, resultUser.getAge());
    }

    @Test
    public void getallUsers() {
        //when(userService.findByUsername(any())).thenReturn(new User("test", 8, 9));

        List<User> userList = Stream.of(
                new User("user1",10,1,"user1","user1@gmail.com"),
                new User("user2",20,2,"user2","user2@gmail.com"),
                new User("user3",30,3,"user3","user3@gmail.com"),
                new User("user4",40,4,"user4","user4@gmail.com")
        ).collect(Collectors.toList());
        when(userService.getAllUser()).thenReturn(userList);
        ResponseEntity<?> user = userController.getAllUsers();
        assertNotNull(user);
        assertEquals(200, user.getStatusCodeValue());
        List<User> resultUser = (List<User>) user.getBody();
        assertEquals(4, resultUser.size());
    }
}