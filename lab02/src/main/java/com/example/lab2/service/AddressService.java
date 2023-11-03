package com.example.lab2.service;

import com.example.lab2.entity.Address;
import com.example.lab2.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> findAll(){
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }
    @Transactional
    public Optional<Address> findById(int id){
        return addressRepository.findById(id);
    }
    public void addAndUpdateAddress(Address user){
        addressRepository.save(user);
    }

    public void deleteAddressById(int id){
        addressRepository.deleteById(id);
    }
}
