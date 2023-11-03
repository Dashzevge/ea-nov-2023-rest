package com.example.lab2.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private int rating;

    @OneToOne
    private Category category;

    @OneToMany
    private List<Review> reviews;
}
