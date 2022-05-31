package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.IUserService;
import com.bridgelabz.bookstoreapp.Service.UserService;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/BookStore")
public class UserController {

   @Autowired
    private IUserService userService;

    @RequestMapping(value = {"","/","getAll"})
    public ResponseEntity<ResponseDTO> getAllUser(){
        List<UserData> userData = null;
        userData = userService.getAllUser();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Success",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyID/{id}")
    public ResponseEntity<ResponseDTO> getUserByid(@PathVariable("id") int id){
        UserData userData = null;
        userData = userService.getUserByid(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addUser(@Valid @RequestBody UserDTO userDTO){
        UserData userData = null;
        userData = userService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For create UserData",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable int id,@RequestBody UserDTO userDTO){
        UserData userData = null;
        userData = userService.updateUser(id,userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Update Successfully",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUserData(@PathVariable("id") int id){
        userService.deleteUserData(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete User Successfully","Deleted id"+id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }


}
