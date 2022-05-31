package com.bridgelabz.bookstoreapp.dto;

public class CartDTO {

    public int id;
    public long userid;
    public long Bookid;
    public int Qty;

    public CartDTO(int id,int userid,int Bookid,int Qty){
        this.id = id;
        this.userid = userid;
        this.Bookid = Bookid;
        this.Qty = Qty;

    }
}
