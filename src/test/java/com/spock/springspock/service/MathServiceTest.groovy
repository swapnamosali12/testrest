package com.spock.springspock.service

import spock.lang.Specification

class MathServiceTest extends Specification {
    def MathService matheService= new MathService();
    def "Addition"() {
        when:
       def add= matheService.addition(2,3)
        then:
        assert add ==5
    }

    def "Multiplication"() {
        when:
        def mul= matheService.multiplication(2,3)
        then:
         mul ==6
    }

    def "Division"() {
        when:
        def div= matheService.division(6,3)
        print("value " +div)
        then:
        assert div ==2.0
    }

}
