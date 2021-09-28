package com.example.listingapp.dto;

import com.example.listingapp.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveDto {

    private int id;
    private String name;
    private String surname;
    private String email;
    private Role role;
}
