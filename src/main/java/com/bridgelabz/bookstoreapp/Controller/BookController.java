package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.IBookService;
import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"","/","getAll"})
    public ResponseEntity<ResponseDTO> getAllBook(){
        List<BookData>bookData = null;
        bookData = bookService.gatAllBook();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Success",bookData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyID/{id}")
    public ResponseEntity<ResponseDTO> getBookByid(@PathVariable("id") int id){
        BookData bookData = null;
        bookData = bookService.getBookbyid(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id",bookData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    @GetMapping(value = "/getcount")
    public ResponseEntity<ResponseDTO> getAddressBookDataCount() {
        List<BookData> listOfBooks = bookService.getAllBookData();
        Integer count = listOfBooks.size();
        ResponseDTO dto = new ResponseDTO("Book count successfully (:", count,null);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @PostMapping("/Insert")
    public ResponseEntity<ResponseDTO> InsertBook(@Valid @RequestBody BookDTO bookDTO){
        BookData bookData = bookService.InsertBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For create bookData",bookData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping ("/updatebookbyid/{id}")
    public ResponseEntity<ResponseDTO> updateBookByid(@PathVariable int id,@RequestBody BookDTO bookDTO){
        BookData bookData = null;
        bookData =  bookService.updateBookByid(id,bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("book Update Successfully",bookData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete id Successfully : " ,"Deleted id is"+id,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
