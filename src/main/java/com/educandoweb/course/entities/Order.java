package com.educandoweb.course.entities;

import com.educandoweb.course.entities.enuns.OrderStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;


@EqualsAndHashCode
@AllArgsConstructor
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

    public OrderStatusEnum getOrderStatus() {
        return OrderStatusEnum.valueEnumOf(orderStatus);
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCodeStatus(); ;
        }
    }
}
