package com.example.lab2.service;

import com.example.lab2.entity.User;
import com.example.lab2.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    public List<User> findAll(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
    @Transactional
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
    public void addAndUpdateUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }
}
