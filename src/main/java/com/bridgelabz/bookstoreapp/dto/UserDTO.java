package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;

    private String lastName;

    private String password;

    private String Address;

    private String email;
    public boolean verified;


}
