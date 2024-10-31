package com.aws.gallery.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=50, nullable = false, unique = true)
    private String email;

    @Column(length=100, nullable=false)
    private String password;
}

