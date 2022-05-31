package com.bridgelabz.bookstoreapp.modal;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
public @Data class BookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Book_id")
    private int id;
    private String BookName;
    private String AuthorName;
    private String BookDescription;
    private String BookImg;
    private int price;
    private int Qty;

    public BookData(BookDTO bookDTO){
        this.BookName = bookDTO.BookName;
        this.AuthorName = bookDTO.AuthorName;
        this.BookDescription = bookDTO.BookDescription;
        this.BookImg = bookDTO.BookImg;
        this.price = bookDTO.price;
        this.Qty = bookDTO.Qty;
    }

    public BookData() {

    }

    public void updateBookByid(BookDTO bookDTO) {
        this.BookName = bookDTO.BookName;
        this.AuthorName = bookDTO.AuthorName;
        this.BookDescription = bookDTO.BookDescription;
        this.BookImg = bookDTO.BookImg;
        this.price = bookDTO.price;
        this.Qty = bookDTO.Qty;
    }
}
