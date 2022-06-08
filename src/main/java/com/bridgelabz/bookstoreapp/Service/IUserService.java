package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.ForgotPassDTO;
import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<ResponseDTO> createAccount(UserDTO userDTO);

    ResponseEntity<ResponseDTO> forgotPwd(ForgotPassDTO forgotPWDDto);

    ResponseEntity<ResponseDTO> loginUser(LoginDTO loginDTO);
    List<UserData> getAllUser();

    UserData getUserByid(int id);

    UserData addUser(UserDTO userDTO);

    UserData updateUser(int id,UserDTO userDTO);

    void deleteUserData(int id);

    ResponseEntity<ResponseDTO> verify(String token);
}
