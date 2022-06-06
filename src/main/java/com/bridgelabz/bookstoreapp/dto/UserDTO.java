package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;

    private String lastName;

    private String password;

    private String Address;

    private String Email;
    public boolean verified;

    public UserDTO(String firstName, String lastName, String password, String Address, String Email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.Address = Address;
        this.Email = Email;
        this.verified=false;
    }


    public String toString(){
        return  "firstName" +firstName+"lastname"+lastName+"password" +password+ "Address" +Address+ "Email" +Email;
}

}
