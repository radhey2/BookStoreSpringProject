package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.ICustomerService;
import com.bridgelabz.bookstoreapp.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.modal.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/Customerdetail")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/getAllCustomer")
    public ResponseEntity<ResponseDTO> getAllCustomer(){
        List<CustomerData> customerDataList = customerService.getAllDetail();
        ResponseDTO responseDTO = new ResponseDTO("Get Customer Detail SuccessFully",customerDataList,null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<ResponseDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerData customerData = customerService.addNewCustomer(customerDTO);
        ResponseDTO responseDTO = new ResponseDTO("New Customer Added Successfully",customerData,null);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
