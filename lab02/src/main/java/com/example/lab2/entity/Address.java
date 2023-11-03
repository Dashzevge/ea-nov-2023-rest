package com.example.lab2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne
    private User user;
}
