package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.modal.CustomerData;

import java.util.List;

public interface ICustomerService {
    List<CustomerData> getAllDetail();

    CustomerData addNewCustomer(CustomerDTO customerDTO);
}
