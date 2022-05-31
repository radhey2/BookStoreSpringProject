package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.BookRepository;
import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.exception.BookException;
import com.bridgelabz.bookstoreapp.modal.BookData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService implements IBookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookData> gatAllBook() {

        return bookRepository.findAll();
    }

    @Override
    public BookData InsertBook(BookDTO bookDTO) {
        BookData bookData = null;
        bookData = new BookData(bookDTO);
        log.debug("bookData"+bookData.toString());
        return bookRepository.save(bookData);
    }

    @Override
    public BookData getBookbyid(int id) {
        return bookRepository
                .findById(id)
                .orElseThrow(()-> new BookException("Book with Id : " +id+ "does not Exist"));
    }

    @Override
    public BookData updateBookByid(int id,BookDTO bookDTO) {
        BookData bookData = this.getBookbyid(id);
        bookData.updateBookByid(bookDTO);
        return bookRepository.save(bookData);
    }

    @Override
    public void deleteBook(int id) {
        BookData bookData = this.getBookbyid(id);
        bookRepository.delete(bookData);
    }

}
