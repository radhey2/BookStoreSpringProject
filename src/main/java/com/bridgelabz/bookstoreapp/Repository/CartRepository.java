package com.bridgelabz.bookstoreapp.Repository;

import com.bridgelabz.bookstoreapp.modal.CartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CartRepository extends JpaRepository<CartData,Integer> {

}
