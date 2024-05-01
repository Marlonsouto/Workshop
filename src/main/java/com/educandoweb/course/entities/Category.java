package com.educandoweb.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode
@ToString
@Getter

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    private static final Long serialVersionUDI = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name")
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(String nome) {
        this.nome = nome;
    }
}
