package com.educandoweb.course.entities;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    String name;
    String email;
    String phone;
    String password;

}
