package com.example.listingapp.repository;

import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


}
