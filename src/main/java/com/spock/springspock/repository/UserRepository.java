package com.spock.springspock.repository;

import com.spock.springspock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Integer>{
    User findByUserName(String name);
}
