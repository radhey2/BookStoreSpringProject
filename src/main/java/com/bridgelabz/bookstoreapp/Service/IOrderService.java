package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.modal.CartData;
import com.bridgelabz.bookstoreapp.modal.OrderData;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderData> getAll();

    OrderData InsertOrder(OrderDTO orderDTO);

    Optional<OrderData> CancelOrder(int orderid);

    Optional<OrderData> Getbyid(int orderid);
}
