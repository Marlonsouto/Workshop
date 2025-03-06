package com.educandoweb.course.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@ToString

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    private static final Long serialVersionUDI = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name_product")
    private String nome;
    @Setter
    private String description;
    @Setter
    private Double price;
    @Setter
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_products_category",joinColumns = @JoinColumn(name = "product_id")
            ,inverseJoinColumns = @JoinColumn(name="category_id"))
    private final Set<Category> categories = new HashSet<>();

    public Product(Long id, String nome, String description, Double price, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }
}
