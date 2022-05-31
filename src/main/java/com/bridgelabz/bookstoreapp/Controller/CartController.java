package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.IcartService;
import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.CartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/Cart")
public class CartController {

    private IcartService cartService;

    @RequestMapping(value = "/getAll")
    public ResponseEntity<ResponseDTO> getAllCart() {
        List<CartData> cartData = null;
        cartData = cartService.gatAllCart();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Success", cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyID/{id}")
    public ResponseEntity<ResponseDTO> getCartByid(@PathVariable("id") int id) {
        CartData cartData = null;
        cartData = cartService.getCartbyid(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id", cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/Insert")
    public ResponseEntity<ResponseDTO> InsertCart(@Valid @RequestBody CartDTO cartDTO){
        CartData cartData = cartService.InsertCart(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For create bookData",cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping ("/updatebookbyid/{id}")
    public ResponseEntity<ResponseDTO> updateBookByid(@PathVariable int id,int userid,@RequestBody CartDTO cartDTO){
        CartData cartData = cartService.updateCartByid(id,userid,cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("book Update Successfully",cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping ("/updateQty/{id}")
    public ResponseEntity<ResponseDTO> updateQty(@PathVariable int id,@RequestBody CartDTO cartDTO){
        CartData cartData = cartService.updateCartByid(id,cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("book Update Successfully",cartData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteCart(@PathVariable("id") int id) {
        cartService.deleteCart(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete book Successfully", "Deleted id" + id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}


