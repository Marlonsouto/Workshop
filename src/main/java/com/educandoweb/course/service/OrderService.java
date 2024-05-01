package com.educandoweb.course.service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrdes(){
        return orderRepository.findAll();
    }

    //@SuppressWarnings("OptionalGetWithoutIsPresent")
    public Order findUserById(Long id){
       //return Oder.findById(id);
       Optional<Order> order = orderRepository.findById(id);
        validator(order);
        return order.get();
    }

    private void validator(Optional<Order> order) {
        if (order.isEmpty()) {
            throw new NoSuchElementException("User not found ");
        }
    }

}
