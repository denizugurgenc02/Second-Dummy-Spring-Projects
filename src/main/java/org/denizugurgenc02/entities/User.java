package org.denizugurgenc02.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private  String username;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "firstname", nullable = true)
    private String firstName;

    @Column(name = "lastname", nullable = true)
    private String lastName;
}
