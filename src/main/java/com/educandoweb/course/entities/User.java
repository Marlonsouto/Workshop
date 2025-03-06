package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode

@Entity
@Table(name = "tb_users")
public class User implements Serializable {

    //@SerialllArgsConstructor
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    String name;

    @Email
    @NonNull @NotBlank
    String email;

    @NonNull @NotBlank
    String phone;

    @NonNull @NotBlank
    String password;

    public User(Long id, @NonNull String name, @NonNull String email,
                @NonNull String phone, @NonNull String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
