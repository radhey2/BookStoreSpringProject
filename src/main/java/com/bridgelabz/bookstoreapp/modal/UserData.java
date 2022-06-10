package com.bridgelabz.bookstoreapp.modal;

import com.bridgelabz.bookstoreapp.dto.UserDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public @Data class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String Address;
    private String email;
    public boolean verified;
    public UserData(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.password = userDTO.getPassword();
        this.Address = userDTO.getAddress();
        this.email = userDTO.getEmail();
        this.verified = userDTO.verified;
    }

    public UserData() {

    }

    public void updateUser(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.password = userDTO.getPassword();
        this.Address = userDTO.getAddress();
        this.email = userDTO.getEmail();
    }
}

