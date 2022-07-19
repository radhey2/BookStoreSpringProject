package com.bridgelabz.bookstoreapp.modal;

import com.bridgelabz.bookstoreapp.dto.CustomerDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
public @Data class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerId")
    private int Customerid;
    private String fullname;
    private String phone;
    private String address;
    private String email;

    public CustomerData(CustomerDTO customerDTO){
        this.fullname = customerDTO.fullname;
        this.phone = customerDTO.phone;
        this.address =customerDTO.address;
        this.email = customerDTO.email;
    }

    public CustomerData(){

    }
}
