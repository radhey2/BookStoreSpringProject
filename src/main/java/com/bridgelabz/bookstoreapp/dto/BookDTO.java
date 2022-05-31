package com.bridgelabz.bookstoreapp.dto;

import java.awt.geom.QuadCurve2D;

public class BookDTO {
    public String BookName;
    public String AuthorName;
    public String BookDescription;
    public String BookImg;
    public int price;
    public int Qty;

    public BookDTO(String BookName, String AuthorName, String BookDescription, String BookImg, int price, int qty){
        this.BookName= BookName;
        this.AuthorName = AuthorName;
        this.BookDescription = BookDescription;
        this.BookImg = BookImg;
        this.price = price;
        this.Qty = Qty;
    }

}
