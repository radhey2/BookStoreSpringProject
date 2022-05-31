package com.bridgelabz.bookstoreapp.modal;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
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

   public CartData(BookData bookData,UserData userData,CartDTO cartDTO){
        this.userData = userData;
        this.bookData = bookData;
        this.Qty = cartDTO.Qty;
    }
    public CartData(CartDTO cartDTO){
       this.userData= cartDTO.userid;
       this.

    }
    public void updateCartByid(CartDTO cartDTO,BookData bookData, UserData userData) {
        this.userData = userData;
        this.bookData = bookData;
        this.Qty = cartDTO.Qty;

    }
}
