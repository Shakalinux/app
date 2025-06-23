package com.shakalinux.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String fullname;

    @Email(message = "Email inválido")
    @Column(nullable = false, columnDefinition = "VARCHAR(70)")
    private String email;

    @Column(nullable = false)
    @Size(min = 3, message = "A senha deve conter no minímo 3 caracteres")
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;
}