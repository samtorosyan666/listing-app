package com.example.listingapp.service;

import com.example.listingapp.model.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingService {

    List<Listing> getAllListings();

    List<Listing> findByEmail(String email);

    List<Listing> findListingByCategoryId(int categoryId);

    Listing findListById(int listId);

    Listing addListing(Listing listing);

    Listing putListing(int id, Listing listing);

    void deleteListing(int id);



}
