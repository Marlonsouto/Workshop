package com.educandoweb.course.service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
       //return userRepository.findById(id);
       Optional<User> user = userRepository.findById(id);
       validator(user);
       return user.get();
    }
    private void validator(Optional<User> user) {
        if (user.isEmpty()) {
            throw new NoSuchElementException("Order not found ");
        }
    }

}
