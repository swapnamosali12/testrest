package com.spock.springspock.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public Integer addition(int a, int b) {
        return a + b;
    }

    public Integer multiplication(int a, int b) {
        return a * b;
    }

    public Double division(int a, int b) {
        return Double.valueOf(a / b);
    }
}
