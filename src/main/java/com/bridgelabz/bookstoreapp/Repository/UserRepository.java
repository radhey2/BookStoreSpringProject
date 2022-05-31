package com.bridgelabz.bookstoreapp.Repository;

import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {
}
