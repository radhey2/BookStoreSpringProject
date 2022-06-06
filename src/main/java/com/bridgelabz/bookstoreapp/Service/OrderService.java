package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.BookRepository;
import com.bridgelabz.bookstoreapp.Repository.CartRepository;
import com.bridgelabz.bookstoreapp.Repository.OrderRepository;
import com.bridgelabz.bookstoreapp.Repository.UserRepository;
import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.exception.BookException;
import com.bridgelabz.bookstoreapp.exception.OrderException;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.CartData;
import com.bridgelabz.bookstoreapp.modal.OrderData;
import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<OrderData> getAll() {
         List<OrderData> orderDataList = orderRepository.findAll();
         return orderDataList;
    }

    @Override
    public OrderData InsertOrder(OrderDTO orderDTO) {
        Optional<BookData> book = bookRepository.findById(orderDTO.getBookid());
        Optional<UserData> userRegistration = userRepository.findById(orderDTO.getUserid());
        if (book.isPresent() && userRegistration.isPresent()) {
            OrderData orderData = new OrderData(orderDTO,book.get(),userRegistration.get());
            orderRepository.save(orderData);
            return orderData;
        } else {
            throw new BookException("Book or User does not exists");
        }

    }

    @Override
    public Optional<OrderData> CancelOrder(int orderid) {
        Optional<OrderData> deleteData = orderRepository.findById(orderid);
        if (deleteData.isPresent()) {
            orderRepository.deleteById(orderid);
            return deleteData;
        } else {
            throw new OrderException(" Did not get any order for specific order id ");
        }
    }

    @Override
    public Optional<OrderData> Getbyid(int orderid) {
        Optional<OrderData> getOrderData = orderRepository.findById(orderid);
        if (getOrderData.isPresent()) {
            return getOrderData;
        } else {
            throw new OrderException(" Didn't find any record for this particular cartId");
        }
    }

}
