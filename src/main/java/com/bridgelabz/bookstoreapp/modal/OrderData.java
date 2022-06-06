package com.bridgelabz.bookstoreapp.modal;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public @Data class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid", nullable = false)
    private int orderid;

    private LocalDate date;
    private int price;
    private int quantity;
    private String address;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private BookData bookData;

    boolean cancel;

    public OrderData(){

    }
    public OrderData(OrderDTO orderDTO, BookData bookData, UserData userData) {
        this.cancel = orderDTO.cancel;
        this.bookData = bookData;
        this.userData = userData;
        this.address = orderDTO.address;
        this.date = orderDTO.date;
        this.price = orderDTO.price;
        this.quantity = orderDTO.quantity;
    }
}
