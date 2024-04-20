package com.educandoweb.course.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "tb_users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;

    @Email
    @NonNull @NotBlank
    @Column(name = "email")
    String email;

    @NonNull @NotBlank
    @Column(name = "phone")
    String phone;

    @NonNull @NotBlank
    @Column(name = "password")
    String password;

    //spring.application.name=course

}
