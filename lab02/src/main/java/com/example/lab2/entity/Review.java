package com.example.lab2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    private int id;
    private String comment;

    @OneToOne
    private User user;

    @OneToOne
    private Product product;
}
