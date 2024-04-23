package com.educandoweb.course.service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
       //return userRepository.findById(id);
       Optional<User> user = userRepository.findById(id);
       return user.get();
    }

}
