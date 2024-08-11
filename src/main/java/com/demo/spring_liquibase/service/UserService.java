package com.demo.spring_liquibase.service;

import com.demo.spring_liquibase.model.UserModel;
import com.demo.spring_liquibase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<UserModel> getUsersByDomain(String domain){
        return repo.findUsersByDomain(domain);
    }

    public List<UserModel> getUsersByAge(int age){
        return repo.findUsersByAge(age);
    }

}
