package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.UserRepository;
import com.bridgelabz.bookstoreapp.Util.TokenUtil;
import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.exception.UserExecption;
import com.bridgelabz.bookstoreapp.modal.Email;
import com.bridgelabz.bookstoreapp.modal.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    IEmailService emailService;


    @Override
    public ResponseEntity<ResponseDTO> createAccount(UserDTO userDTO) {

        UserData userData= userRepository.save(new UserData(userDTO));

        String token = tokenUtil.createToken(Long.valueOf(userData.getId()));

        Email email = new Email(userData.getEmail()," user is registered",userData.getFirstName() + "=>" + emailService.getLink(token));
        emailService.sendMail(email);
        ResponseDTO responseDto = new ResponseDTO("User is created", userData, token);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Override
    public  List<UserData> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public UserData getUserByid(int id) {
        return userRepository
                .findById(id)
                .orElseThrow(()-> new UserExecption("User with Id:" +id+ "Does not Exist"));
    }

    @Override
    public UserData addUser(UserDTO userDTO) {
        UserData userData = new UserData(userDTO);
        log.debug("bookData"+userData.toString());
        return userRepository.save(userData);
    }
    @Override
    public UserData updateUser(int id,UserDTO userDTO) {
        UserData userData = this.getUserByid(id);
        userData.updateUser(userDTO);
        return userRepository.save(userData);
    }

    @Override
    public void deleteUserData(int id){
        UserData userData = this.getUserByid(id);
        userRepository.delete(userData);

    }

    @Override
    public ResponseEntity<ResponseDTO> loginUser(LoginDTO loginDTO) {
        Optional<UserData> user = userRepository.findByEmail(loginDTO.getEmail());
        boolean password = user.get().getPassword().equals(loginDTO.getPassword());
        if (password = false) {
            ResponseDTO responseDto = new ResponseDTO("login failed", null, null);
            return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.UNAUTHORIZED);
        } else {
            ResponseDTO responseDto = new ResponseDTO(" LOgin Sucessfully", user, null);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<ResponseDTO> verify(String token) {
        Optional<UserData> user=userRepository.findById(Math.toIntExact(tokenUtil.decodeToken(token)));
        if (user.isEmpty()) {
            ResponseDTO responseDTO = new ResponseDTO("ERROR: Invalid token", null, token);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.UNAUTHORIZED);
        }
        user.get().setVerified(true);
        userRepository.save(user.get());
        ResponseDTO responseDTO = new ResponseDTO(" The user has been verified ", user, token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}
