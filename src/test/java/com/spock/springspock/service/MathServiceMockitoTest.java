package com.spock.springspock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class MathServiceMockitoTest {
    @InjectMocks
    MathService mathService;
    @Test
    public void testAddition(){
       int addition= mathService.addition(5,6);
       assertEquals(11,addition);
    }
    @Test
    public  void testmultiplication(){
        int mul= mathService.multiplication(7,7);
        assertEquals(49,mul);
    }
    @Test
    public  void testDivision(){
        Double divison =mathService.division(9,3);
        assertEquals(3,divison);
    }

}