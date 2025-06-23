package com.shakalinux.app.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Acess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAcesso;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
