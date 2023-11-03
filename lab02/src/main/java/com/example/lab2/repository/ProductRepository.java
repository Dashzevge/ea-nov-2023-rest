package com.example.lab2.repository;

import com.example.lab2.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    List<Product> findByPriceGreaterThan(double minPrice);

    List<Product> findByCategoryAndPriceLessThan(String category, double maxPrice);

    List<Product> findByNameContaining(String keyword);

}
