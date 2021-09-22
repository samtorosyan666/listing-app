package com.example.listingapp.controller;

import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> getAllLists() {
        return listingService.getAllListings();
    }

    @GetMapping("/listings/byUser/{email}")
    public List<Listing> getAllListingsByUserEmail(@PathVariable("email") String email) {
        return listingService.findByEmail(email);
    }

    @GetMapping("/listings/byCategory/{categoryId}")
    public List<Listing> getAllListingsByCategoryId(@PathVariable("categoryId") int id) {
        return listingService.findListingByCategoryId(id);
    }

    @GetMapping("/listings/{id}")
    public Listing getListingById(@PathVariable("id") int id) {
        return listingService.findListById(id);
    }

    @PostMapping("/listings")
    public Listing addCategory(@RequestBody Listing listing) {
        return listingService.addListing(listing);
    }

    @PutMapping("/listings/{id}")
    public Listing putListing(@PathVariable int id, @RequestBody Listing listing) {
        return listingService.putListing(id, listing);
    }

    @DeleteMapping("/listings/{id}")
    public void deletelisting(@PathVariable int id) {
        listingService.deleteListing(id);
    }

}
