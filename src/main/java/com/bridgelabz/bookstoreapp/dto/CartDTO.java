package com.bridgelabz.bookstoreapp.dto;

import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.UserData;
import lombok.Data;

public @Data class CartDTO {

    public int bookid;
    public int userid;
    public int Qty;


}
