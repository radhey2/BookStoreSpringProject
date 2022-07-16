package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.modal.CartData;

import java.util.List;
import java.util.Optional;

public interface IcartService {

    List<CartData> gatAllCart();

    Optional<CartData> getCartbyid(int userid);

    Optional<CartData> deleteCart(int userid);

    CartData InsertCart(CartDTO cartDTO);

    CartData updateCartByid(int userid, CartDTO cartDTO);

    CartData updateQty(int userid, int Qty);

    CartData updateQuntity(Integer cartId, int quantity, int total);

    void deleteAllCart(CartDTO cartDTO);
}
