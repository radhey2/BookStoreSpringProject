package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.modal.CartData;

import java.util.List;

public interface IcartService {

    List<CartData> gatAllCart();

    CartData getCartbyid(int id);

    CartData InsertCart(CartDTO cartDTO);

    CartData updateCartByid(int userid, int bookid, CartDTO cartDTO);

    void deleteCart(int id);

}
