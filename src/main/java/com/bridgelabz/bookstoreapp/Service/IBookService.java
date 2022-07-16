package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.UserData;

import java.util.List;

public interface IBookService {

    List<BookData> gatAllBook();

    BookData InsertBook(BookDTO bookDTO);

    BookData getBookbyid(int id);
    BookData updateBookByid(int id, BookDTO bookDTO);

    void deleteBook(int id);

    List<BookData> getAllBookData();
}
