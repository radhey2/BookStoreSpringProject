package com.bridgelabz.bookstoreapp.modal;

import com.bridgelabz.bookstoreapp.dto.CartDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
public @Data class CartData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cartid")
    private int Cartid;
    private int Qty;

    @ManyToOne
    @JoinColumn(name = "Book_id")
    private BookData bookData;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserData userData;
    private Integer total;

    public CartData(int Qty, BookData bookData, UserData userData,Integer total) {
       this.Qty = Qty;
       this.bookData = bookData;
       this.userData = userData;
       this.total = total;
    }
    public CartData() {

    }

    public CartData(int Qty, BookData bookData, UserData userData) {
        this.Qty = Qty;
        this.bookData = bookData;
        this.userData = userData;
    }
}
