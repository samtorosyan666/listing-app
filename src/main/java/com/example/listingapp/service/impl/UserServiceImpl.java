package com.example.listingapp.service.impl;

import com.example.listingapp.model.User;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    @Override
   public User addUser(User user) {
       return userRepository.save(user);
    }


        @Override
        public User putUser(int id, User user) {
            User byId = userRepository.findById(id).get();
            byId.setName(user.getName());
            byId.setSurname(user.getSurname());
            byId.setEmail(user.getEmail());
            byId.setPassword(user.getPassword());
            byId.setRole(user.getRole());
            return userRepository.save(byId);
        }


    @Override
    public void deleteUser(int id) {
    userRepository.deleteById(id);
    }


}
