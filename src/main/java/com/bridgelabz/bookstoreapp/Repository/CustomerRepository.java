package com.bridgelabz.bookstoreapp.Repository;

import com.bridgelabz.bookstoreapp.modal.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<CustomerData,Integer> {
}
