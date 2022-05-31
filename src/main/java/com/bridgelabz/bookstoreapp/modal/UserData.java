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
    private String Email;
    public UserData(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.password = userDTO.getPassword();
        this.Address = userDTO.getAddress();
        this.Email = userDTO.getEmail();
    }

    public UserData() {

    }

//    public UserData(UserDTO userDTO) {
//    }
//
//    public UserData(UserDTO userDTO) {
//    }

    public void updateUser(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.password = userDTO.getPassword();
        this.Address = userDTO.getAddress();
        this.Email = userDTO.getEmail();
    }
}

