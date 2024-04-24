package com.educandoweb.course.controller;


import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.OrderService;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    //teste
    @GetMapping
    public Optional<ResponseEntity<List<Order>>> findAllUsers(){
        var listOrder = orderService.findAll();
        return Optional.of(ResponseEntity.ok().body(listOrder));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findUserById(Long id){
        var OrderId = orderService.findUserById(id);
        return ResponseEntity.ok().body(OrderId);
    }
}
