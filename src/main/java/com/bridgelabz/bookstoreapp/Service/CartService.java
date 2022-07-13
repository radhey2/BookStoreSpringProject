package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.BookRepository;
import com.bridgelabz.bookstoreapp.Repository.CartRepository;
import com.bridgelabz.bookstoreapp.Repository.UserRepository;
import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.exception.BookException;
import com.bridgelabz.bookstoreapp.exception.CartException;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.CartData;
import com.bridgelabz.bookstoreapp.modal.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
@Slf4j
public class CartService implements IcartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CartData> gatAllCart() {
        List<CartData> cartDataList = cartRepository.findAll();
        return cartDataList;
    }

    @Override
    public Optional<CartData> getCartbyid(int id) {
        //   return cartRepository.findById(id).orElseThrow(()->new CartException("Cart id :"+id+ "Does not exist"));
        Optional<CartData> getCartData = cartRepository.findById(id);
        if (getCartData.isPresent()) {
            return getCartData;
        } else {
            throw new BookException(" Didn't find any record for this particular cartId");
        }
    }

    @Override
    public CartData InsertCart(CartDTO cartDTO) {
        Optional<BookData> book = bookRepository.findById(cartDTO.getBookid());
        Optional<UserData> userRegistration = userRepository.findById(cartDTO.getUserid());
        if (book.isPresent() && userRegistration.isPresent()) {
            CartData newCart = new CartData(cartDTO.Qty,book.get(),userRegistration.get());
            cartRepository.save(newCart);
            return newCart;
        } else {
            throw new BookException("Book or User does not exists");
        }
    }

    @Override
    public CartData updateCartByid(int id, CartDTO cartDTO) {
        Optional<CartData> cart = cartRepository.findById(id);
        Optional<BookData> book = bookRepository.findById(cartDTO.getBookid());
        Optional<UserData> user = userRepository.findById(cartDTO.getUserid());
        if (cart.isEmpty()) {
            throw new CartException("Cart Record doesn't exists");
        } else {
            if (book.isPresent() && user.isPresent()) {
                CartData newCart = new CartData(cartDTO.Qty,book.get(), user.get());
                cartRepository.save(newCart);
                return newCart;
            } else {
                throw new BookException("Book or User doesn't exists");
            }
        }
    }

    @Override
    public Optional<CartData> deleteCart(int id) {
        Optional<CartData> deleteData = cartRepository.findById(id);
        if (deleteData.isPresent()) {
            cartRepository.deleteById(id);
            return deleteData;
        } else {
            throw new BookException(" Did not get any cart for specific cart id ");
        }

    }
    @Override
    public CartData updateQty(int id, int Qty) {
        Optional<CartData> cart = cartRepository.findById(id);
        Optional<BookData>  book = bookRepository.findById(cart.get().getBookData().getBookid());
        if(cart.isEmpty()) {
            throw new BookException("Cart Record doesn't exists");
        }
        else {
            if(Qty < book.get().getQty()) {
                cart.get().setQty(Qty);
                cartRepository.save(cart.get());
//                book.get().setQty((book.get().getQty() - (Qty - cart.get().getQty())));
//                bookRepository.save(book.get());
                return cart.get();
            }
            else {
                throw new BookException("Requested quantity is not available");
            }
        }
    }

    @Override
    public CartData updateQuntity(Integer cartId, int Qty, int total) {
        Optional<CartData> cartData=cartRepository.findById(cartId);
        if (cartData.isEmpty()){
            throw new CartException("invalid id please input valid Id");
        }
        cartData.get().setQty(Qty);
        cartData.get().setTotal(total);
        cartRepository.save(cartData.get());
        return cartData.get();
    }

}
