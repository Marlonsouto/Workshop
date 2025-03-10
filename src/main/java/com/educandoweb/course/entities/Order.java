package com.educandoweb.course.entities;

import com.educandoweb.course.entities.enuns.OrderStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM'T'HH-mm-ss'z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id.order" )
    private final Set<OrderItem> orderItems = new HashSet<>();

    public Order(Long id, Instant moment, OrderStatusEnum orderStatus, User user) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.user = user;
    }

    public Set<OrderItem> getOrderItems(){
        return orderItems;
    }
    public OrderStatusEnum getOrderStatus() {
        return OrderStatusEnum.valueEnumOf(orderStatus);
    }

    public void setOrderStatus(OrderStatusEnum status) {
        if(status != null) {
            this.orderStatus = status.getCodeStatus();
        }
    }
}
