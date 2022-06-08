package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.IOrderService;
import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.modal.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @GetMapping(value = "/GetAll")
    public ResponseEntity<ResponseDTO> getAll(){
        List<OrderData> orderData = null;
        orderData = orderService.getAll();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Success", orderData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyid/{orderid}")
    public ResponseEntity<ResponseDTO>Getbyid(@PathVariable("orderid") int orderid){
        Optional<OrderData> orderData = orderService.Getbyid(orderid);
        ResponseDTO responseDTO = new ResponseDTO("Get Call SuccessFull for orderId :" +orderid,orderData,null);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping(value = "/Insert")
    public ResponseEntity<ResponseDTO> InsertOrder(@Valid @RequestBody OrderDTO orderDTO){
        OrderData orderData = orderService.InsertOrder(orderDTO);
        ResponseDTO responseDTO = new ResponseDTO("Order Placed SuccessFully",orderData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping(value = "/cancel/{orderid}")
    public ResponseEntity<ResponseDTO> CancelOrder(@PathVariable ("orderid") int orderid){
        Optional<OrderData> orderData = orderService.CancelOrder(orderid);
        ResponseDTO responseDTO = new ResponseDTO("Order Cancel SuccessFully",orderData,null);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
