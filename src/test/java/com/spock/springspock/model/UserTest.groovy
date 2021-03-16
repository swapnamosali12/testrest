package com.spock.springspock.model

import spock.lang.Specification

class UserTest extends Specification {
    User user= new User()
    def "set user name and get username"(){
        when :
        user.setUserName(name)

        then :
        user.getUserName().equals(expected)
        where :
        name        | expected
        "user1"       |   "user1"
        "user2"       |   "user2"
        "user3"       |   "user3"
    }
    def "if we set null values we need to throw exception"(){
        when:
        user.setUserName(null)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == "Username given was invalid"
    }


}
