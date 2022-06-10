package com.bridgelabz.bookstoreapp.Repository;

import com.bridgelabz.bookstoreapp.modal.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface OrderRepository extends JpaRepository<OrderData,Integer> {

}
