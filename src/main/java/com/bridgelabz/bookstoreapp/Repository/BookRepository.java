package com.bridgelabz.bookstoreapp.Repository;

import com.bridgelabz.bookstoreapp.modal.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository extends JpaRepository<BookData,Integer> {
}
