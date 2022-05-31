package com.bridgelabz.bookstoreapp.Service;

import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.modal.UserData;

import java.util.List;

public interface IUserService {
    List<UserData> getAllUser();

    UserData getUserByid(int id);

    UserData addUser(UserDTO userDTO);

    UserData updateUser(int id,UserDTO userDTO);

    void deleteUserData(int id);
}
