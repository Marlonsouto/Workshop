package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enuns.OrderStatusEnum;
import com.educandoweb.course.repository.OrderRepository;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Configuration
@Profile("teste")
public class TestConfig {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    public void run (String... args) throws Exception {

        User user1 = new User(null, "John Doe", "john@example.com", "123456789", "password1");
        User user2 = new User(null, "Jane Smith", "jane@example.com", "987654321", "password2");

        Order order2 = new Order(null, Instant.parse("2024-04-21T19:30:08z"), OrderStatusEnum.PAID,user1);
        Order order1 = new Order(null, Instant.parse("2024-04-21T19:30:08z"),OrderStatusEnum.DELIVERED,user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order2,order1));
    }



}
