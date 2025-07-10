package com.lucas.designfactorybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Boolean certificate;
}
