package com.example.listingapp.service.impl;

import com.example.listingapp.model.Listing;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;


    @Override
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public List<Listing> findByEmail(String email) {
        return listingRepository.findAllListingsByUser_Email(email);
    }

    @Override
    public List<Listing> findListingByCategoryId(int categoryId) {
        return listingRepository.findAllListingsByCategory_Id(categoryId);
    }

    @Override
    public Listing findListById(int listId) {
        return listingRepository.findById(listId).get();
    }

    @Override
    public Listing addListing(Listing listing) {
        return listingRepository.save(listing);
    }


    @Override
    public Listing putListing(int id, Listing listing) {
        Listing listingById = listingRepository.findById(id).get();
        listingById.setTitle(listing.getTitle());
        listingById.setDescription(listing.getDescription());
        listingById.setPrice(listing.getPrice());
        listingById.setCategory(listing.getCategory());
        listingById.setUser(listing.getUser());
        return listingRepository.save(listingById);
    }

    @Override
    public void deleteListing(int id) {
        listingRepository.deleteById(id);
    }
}
