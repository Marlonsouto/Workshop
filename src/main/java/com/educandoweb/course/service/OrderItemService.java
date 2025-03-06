package com.educandoweb.course.service;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.repository.OrderItemRepository;
import com.educandoweb.course.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAllOrdes(){
        return orderItemRepository.findAll();
    }

    public OrderItem findUserById(Long id){
       //return Oder.findById(id);
       Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        validator(orderItem);
        return orderItem.get();
    }

    private void validator(Optional<OrderItem> order) {
        if (order.isEmpty()) {
            throw new NoSuchElementException("User not found ");
        }
    }

}
