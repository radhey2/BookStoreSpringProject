package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.CustomerRepository;
import com.bridgelabz.bookstoreapp.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.modal.CustomerData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerData> getAllDetail() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerData addNewCustomer(CustomerDTO customerDTO) {
        CustomerData customerData = new CustomerData(customerDTO);
        log.debug("cutomerData"+customerData.toString());
        return customerRepository.save(customerData);
    }
}
