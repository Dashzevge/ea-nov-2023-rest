package com.example.lab2.controller;

import com.example.lab2.entity.Review;
import com.example.lab2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<Review> findAll() {
        return this.reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Review> findById(@PathVariable int id) {
        return this.reviewService.findById(id);
    }

    @GetMapping("/byProductId")
    public List<Review> getReviewsByProductId(@RequestParam Integer id) {
        return reviewService.findByProductId(id);
    }
    @PostMapping
    public void save(@RequestBody Review review) {
        this.reviewService.addAndUpdateReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.reviewService.deleteReviewById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Review review) {
        this.reviewService.addAndUpdateReview(review);
    }
}
