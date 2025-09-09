package com.lucas.designfactorybackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private Integer experience;

    @Setter
    @Getter
    private Integer progress_a;

    @Setter
    @Getter
    private Integer progress_b;

    @Setter
    @Getter
    private Integer progress_c;

    @Setter
    @Getter
    private Integer progress_d;

    @Setter
    @Getter
    private Boolean certificate;
}
