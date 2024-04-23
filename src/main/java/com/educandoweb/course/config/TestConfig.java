package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Configuration
@Profile("teste")
public class TestConfig {

    @Autowired
    UserRepository userRepository;

    public void run (String... args) throws Exception {

        User user1 = new User(null, "John Doe", "john@example.com", "123456789", "password1");
        User user2 = new User(null, "Jane Smith", "jane@example.com", "987654321", "password2");
        userRepository.saveAll(Arrays.asList(user1, user2));

    }

}
