package com.educandoweb.course.controller;


import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    //teste
    @GetMapping
    public Optional<ResponseEntity<List<User>>> findAllUsers(){
        var listUser = userService.findAll();
        return Optional.of(ResponseEntity.ok().body(listUser));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(Long id){
        var userId = userService.findUserById(id);
        return ResponseEntity.ok().body(userId);
    }
}
