package com.example.listingapp.repository;

import com.example.listingapp.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ListingRepository extends JpaRepository<Listing,Integer> {

    List<Listing> findAllListingsByUser_Email(String email);

    List<Listing> findAllListingsByCategory_Id(int categoryId);
}
