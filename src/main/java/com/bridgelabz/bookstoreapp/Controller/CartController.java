package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.IcartService;
import com.bridgelabz.bookstoreapp.dto.CartDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.modal.CartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping(value = "/Cart")
public class CartController {

   @Autowired
    private IcartService cartService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<ResponseDTO> getAllCart() {

        List<CartData> cartData = null;
        cartData = cartService.gatAllCart();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Success", cartData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyID/{cartid}")
    public ResponseEntity<ResponseDTO> getCartByid(@PathVariable("cartid") int cartid) {

//        cartData = cartService.getCartbyid(cartid);
        Optional<CartData> cartData = cartService.getCartbyid(cartid);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id", cartData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/Insert")
    public ResponseEntity<ResponseDTO> InsertCart(@Valid @RequestBody CartDTO cartDTO){
        CartData cartData = cartService.InsertCart(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For create bookData",cartData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping ("/updatebookbyid/{cartid}")
    public ResponseEntity<ResponseDTO> updateBookByid(@PathVariable int cartid, @RequestBody CartDTO cartDTO){
        CartData cartData = cartService.updateCartByid(cartid,cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("book Update Successfully",cartData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping ("/updateQty/{cartid}")
    public ResponseEntity<ResponseDTO> updateQty(@PathVariable int cartid,@RequestParam int Qty){
        CartData cartData = cartService.updateQty(cartid,Qty);
        ResponseDTO responseDTO = new ResponseDTO("book Update Successfully",cartData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{cartid}")
    public ResponseEntity<ResponseDTO> deleteCart(@PathVariable("cartid") int cartid) {
        cartService.deleteCart(cartid);
        ResponseDTO responseDTO = new ResponseDTO("Delete book Successfully", "Deleted id" + cartid,null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<ResponseDTO> deleteAllCart(CartDTO cartDTO){
        cartService.deleteAllCart(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Cart is Empty","Empty Cart",null);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/UpdateQunatity/{cartId}/{Qty}/{total}")
    public ResponseEntity<ResponseDTO> updateQuntityData(@PathVariable Integer cartId, @PathVariable int Qty,@PathVariable int total) {
        CartData updateQuntity = cartService.updateQuntity(cartId, Qty,total);
        ResponseDTO dto = new ResponseDTO("Cart quntity update Successfully " ,updateQuntity,null);
        return  new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }


}


