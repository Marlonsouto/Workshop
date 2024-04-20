package com.educandoweb.course.controller;


import com.educandoweb.course.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "users")
public class UserController {

    //teste
    @GetMapping
    public Optional<ResponseEntity<User>> FindAll(){
        User user = new User(1L, "Marlon","Marlon@gmail.com", "0000000", "coxadefrango");
        return Optional.of(ResponseEntity.ok().body(user));
    }
}
