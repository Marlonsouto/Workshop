package com.educandoweb.course.repository;

import com.educandoweb.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, Long> {
}
