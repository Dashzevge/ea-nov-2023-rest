package com.example.lab2.controller;

import com.example.lab2.entity.Address;
import com.example.lab2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<Address> findAll() {
        return this.addressService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> findById(@PathVariable int id) {
        return this.addressService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Address address) {
        this.addressService.addAndUpdateAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.addressService.deleteAddressById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Address address) {
        this.addressService.addAndUpdateAddress(address);
    }

}
