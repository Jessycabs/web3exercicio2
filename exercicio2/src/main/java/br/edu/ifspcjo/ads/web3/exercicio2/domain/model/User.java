package br.edu.ifspcjo.ads.web3.exercicio2.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 6, max = 150)
    @Column(length = 150, nullable = false)
    private String password;

    @Column(length = 20)
    private String phone;

    @NotNull
    private Boolean active;

    // getters e setters (gerar com IDE)
    // equals e hashCode (opcional)
}
