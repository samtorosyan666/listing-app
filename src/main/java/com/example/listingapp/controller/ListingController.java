package com.example.listingapp.controller;

import com.example.listingapp.dto.ListingDto;
import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;

    private final ModelMapper mapper;

    @GetMapping("/listings")
    public List<ListingDto> getAllLists() {
        List<Listing> all = listingService.getAllListings();
        List<ListingDto> listingDtos = new ArrayList<>();
        for (Listing listing : all) {
            ListingDto listingDto = mapper.map(listing, ListingDto.class);
            listingDtos.add(listingDto);
        }
        return listingDtos;
    }

    @GetMapping("/listings/byUser/{email}")
    public List<ListingDto> getAllListingsByUserEmail(@PathVariable("email") String email) {
        List<Listing> byEmail = listingService.findByEmail(email);
        List<ListingDto> listingDtos = new ArrayList<>();
        for (Listing listing : byEmail) {
            ListingDto listingDto = mapper.map(listing, ListingDto.class);
            listingDtos.add(listingDto);
        }
        return listingDtos;
    }

    @GetMapping("/listings/byCategory/{categoryId}")
    public List<ListingDto> findByCategory(@PathVariable("categoryId") int categoryId) {

        List<Listing> byCategoryId = listingService.findListingByCategoryId(categoryId);
        List<ListingDto> listingDtos = new ArrayList<>();
        for (Listing listing : byCategoryId) {
            ListingDto listingDto = mapper.map(listing, ListingDto.class);
            listingDtos.add(listingDto);

        }
        return listingDtos;
    }

    @GetMapping("/listings/{id}")
    public ListingDto getListingById(@PathVariable("id") int id) {
        return mapper.map(listingService.findListById(id),ListingDto.class);
    }

    @PostMapping("/listings")
    public ListingDto addCategory(@RequestBody Listing listing) {
        return mapper.map(listingService.addListing(mapper.map(listing, Listing.class)),ListingDto.class);
    }

    @PutMapping("/listings/{id}")
    public ListingDto putListing(@PathVariable int id, @RequestBody Listing listing) {
        return mapper.map(listingService.putListing(id,mapper.map(listing, Listing.class)),ListingDto.class);
    }

    @DeleteMapping("/listings/{id}")
    public void deletelisting(@PathVariable int id) {
        listingService.deleteListing(id);
    }

}
