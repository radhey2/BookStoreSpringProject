package com.bridgelabz.bookstoreapp.dto;

import com.bridgelabz.bookstoreapp.modal.UserData;
import lombok.Data;

import java.time.LocalDate;

public @Data class OrderDTO {
    public LocalDate date;
    public String address;
    public int price;
    public boolean cancel;
    public int quantity;
    public int userid;
    public int bookid;

    public  OrderDTO(LocalDate date, String address,int price,boolean cancel,int quantity, int userid,int bookid){
        this.address = address;
        this.bookid = bookid;
        this.cancel = cancel;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.userid = userid;

    }
}
