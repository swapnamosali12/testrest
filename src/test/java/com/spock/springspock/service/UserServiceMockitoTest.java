package com.spock.springspock.service;

import com.spock.springspock.model.User;
import com.spock.springspock.model.User;
import com.spock.springspock.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockitoTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    public void getUserFindByName() {
        when(userRepository.findByUserName("testuser")).thenReturn(new User("usertest", 30, 1,"user","user@gmail.com"));
        User user = userService.findByUsername("testuser");
        Assert.assertEquals(30, user.getAge());

    }

    @Test
    public void getUserFindByName_InvalidUsername() {
        //     when(userRepository.findByUserName("testuser")).thenReturn(new User("usertest", 30, 1));
        User user = userService.findByUsername("test");
        Assert.assertNull(user);

    }

}