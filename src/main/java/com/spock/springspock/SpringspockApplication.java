package com.spock.springspock;

import com.spock.springspock.model.User;
import com.spock.springspock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringspockApplication {
	@Autowired
	UserRepository userRepository;
	@PostConstruct
	public void loaduser(){
		List<User> userList= Stream.of(
				new User("user1",10,1,"user1","user1@gmail.com"),
				new User("user2",20,2,"user2","user2@gmail.com"),
				new User("user3",30,3,"user3","user3@gmail.com"),
				new User("user4",40,4,"user4","user4@gmail.com")
		).collect(Collectors.toList());
		userRepository.saveAll(userList);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringspockApplication.class, args);
	}

}
