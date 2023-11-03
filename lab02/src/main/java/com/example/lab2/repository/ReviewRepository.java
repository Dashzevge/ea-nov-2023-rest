package com.example.lab2.repository;

import com.example.lab2.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ReviewRepository extends ListCrudRepository<Review, Integer> {
    @Override
    Optional<Review> findById(Integer id);
    List<Review> findByProductId(Integer id);

}
