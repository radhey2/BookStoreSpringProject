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

    public UserDTO(String firstName, String lastName, String password, String Address, String Email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.Address = Address;
        this.email = Email;
        this.verified=false;
    }

}
