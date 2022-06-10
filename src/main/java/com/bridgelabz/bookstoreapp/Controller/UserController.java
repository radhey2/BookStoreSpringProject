package com.bridgelabz.bookstoreapp.Controller;

import com.bridgelabz.bookstoreapp.Service.IUserService;
<<<<<<< HEAD
=======
import com.bridgelabz.bookstoreapp.dto.ForgotPassDTO;
>>>>>>> UC3_JWT_JMS
import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.modal.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/BookStore")
public class UserController {

   @Autowired
    private IUserService userService;

    @GetMapping(value = {"","/","getAll"})
    public ResponseEntity<ResponseDTO> getAllUser(){
        List<UserData> userData = null;
        userData = userService.getAllUser();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Success",userData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyID/{id}")
    public ResponseEntity<ResponseDTO> getUserByid(@PathVariable("id") int id){
        UserData userData = null;
        userData = userService.getUserByid(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id",userData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addUser(@Valid @RequestBody UserDTO userDTO){
        return userService.createAccount(userDTO);
<<<<<<< HEAD

=======
>>>>>>> UC3_JWT_JMS
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable int id,@RequestBody UserDTO userDTO){
        UserData userData = null;
        userData = userService.updateUser(id,userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Update Successfully",userData,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PostMapping("/forgot")
    public ResponseEntity<ResponseDTO> forgotPwd(@RequestBody ForgotPassDTO forgotPWDDto){
        return userService.forgotPwd(forgotPWDDto);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO){
        return userService.loginUser(loginDTO);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUserData(@PathVariable("id") int id){
        userService.deleteUserData(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete User Successfully","Deleted id"+id,null);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDTO> verify(@PathVariable String token) {
        return userService.verify(token);
    }



    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDTO> verify(@PathVariable String token) {
        return userService.verify(token);
    }


}
