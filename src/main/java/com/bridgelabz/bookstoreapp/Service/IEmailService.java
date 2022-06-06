package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

//import javax.validation.constraints.Email;
import com.bridgelabz.bookstoreapp.modal.Email;
public interface IEmailService {
    public ResponseEntity<ResponseDTO> sendMail(Email email);
    public String getLink(String token);

}
