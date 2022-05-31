package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.Repository.UserRepository;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.exception.UserExecption;
import com.bridgelabz.bookstoreapp.modal.BookData;
import com.bridgelabz.bookstoreapp.modal.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

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

}
