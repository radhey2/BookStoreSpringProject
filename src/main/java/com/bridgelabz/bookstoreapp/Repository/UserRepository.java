package com.bridgelabz.bookstoreapp.Repository;

import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {

    @Query(value = "select * from user_registration where email=?1 password = ?2", nativeQuery = true)
    Long findByPassword(String email, String password);

    //Optional<User> findByEmail(String email);

    // @Query(value = "select * from user where email=?1",nativeQuery = true)
    // Optional<User> getUserByEmail(String email);

    @Query(value = " select  * from user_registrationhere id=?1", nativeQuery = true)
    UserData getById(String id);

    Optional<UserData> findByEmail(String email);
    Optional<UserData> getUserByEmail(String email);
}
