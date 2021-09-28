package com.example.listingapp.dto;

import com.example.listingapp.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListingSaveDto {

    private int id;
    private String title;
    private String description;
    private int price;
    private Category category;

}
