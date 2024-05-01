package com.educandoweb.course.config;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enuns.OrderStatusEnum;
import com.educandoweb.course.repository.CategoryRepository;
import com.educandoweb.course.repository.OrderRepository;
import com.educandoweb.course.repository.ProductRepository;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class TestConfig {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public void run (String... args) throws Exception {



        User user1 = new User(null, "John Doe", "john@example.com", "123456789", "password1");
        User user2 = new User(null, "Jane Smith", "jane@example.com", "987654321", "password2");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order2 = new Order(Instant.parse("2024-04-21T19:30:08z"), OrderStatusEnum.PAID, user1);
        Order order1 = new Order(Instant.parse("2024-04-21T19:30:08z"),OrderStatusEnum.DELIVERED, user1);
        Order order3 = new Order(Instant.parse("2024-04-21T19:30:08z"),OrderStatusEnum.DELIVERED, user2);

        Category c1 = new Category("Electronics");
        Category c2 = new Category("Books");
        Category c3 = new Category("Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);


        orderRepository.saveAll(Arrays.asList(order2,order1));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }



}
