package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.BookRepository;
import com.bridgelabz.bookstoreapp.Repository.CartRepository;
import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.exception.CartException;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.CartData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartService implements IcartService{

    @Autowired
     CartRepository cartRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<CartData> gatAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public CartData getCartbyid(int id) {
        return cartRepository.findById(id).orElseThrow(()->new CartException("Cart id :"+id+ "Does not exist"));
    }

    @Override
    public CartData InsertCart(CartDTO cartDTO) {
        CartData cartData = new CartData()
        log.debug("CartData"+cartData.toString());
        return cartRepository.save(cartData);
    }

    @Override
    public CartData updateCartByid(int userid,int bookid, CartDTO cartDTO) {
        CartData cartData1 = cartRepository.findById(userid).get();
       // cartRepository.findById(bookid);
        BookData bookData = bookRepository.findById(bookid).get();
        CartData cartData = null;
        if (cartData1 != null) {
//            cartData = this.getCartbyid(userid);
//            cartData1.updateCartByid(cartDTO);
            cartData1.setBookData(bookData);

        }
        return cartRepository.save(cartData);
    }
    @Override
    public void deleteCart(int id) {
        CartData cartData = this.getCartbyid(id);
        cartRepository.delete(cartData);
    }

}
