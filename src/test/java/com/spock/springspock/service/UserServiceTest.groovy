package com.spock.springspock.service

import com.spock.springspock.model.User
import com.spock.springspock.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class UserServiceTest extends Specification {
    UserRepository repository = Mock(UserRepository)

    UserService service = new UserService(repository)
    def id = 1

    def "test userservice findByname with valid user"() {
        given:
        1 * repository.findByUserName("usertest") >> new User("usertest", 30, 1,"user4","user4@gmail.com")

        when:
        def user = service.findByUsername("usertest")
        then:
        user.getId() == 1
        user.getUserName().equalsIgnoreCase("USERTEST")
        user.getAge() == 30
    }

    def "test userservice with invalid user name"() {

        //if we provide  given and if we wont use it will say 0 invocation for usetest and Unmatched invocations (ordered by similarity):
 //      given:
   //    1 * repository.findByUserName("usertest") >> null
        when:
        def user = service.findByUsername("test")
        then:
        user == null
    }
}
