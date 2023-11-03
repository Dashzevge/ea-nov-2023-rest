package com.example.lab2.controller;

import com.example.lab2.entity.Product;
import com.example.lab2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable int id) {
        return this.productService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        this.productService.addAndUpdateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Product product) {
        this.productService.addAndUpdateProduct(product);
    }
}
