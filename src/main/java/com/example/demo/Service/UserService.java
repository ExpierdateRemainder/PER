package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.User;



public interface UserService {
	
    List<User> getAllUsers();

    User getUserById(Long user_id);

    User pushUser(User newUser);

    User updateUser(User updatedUser, Long user_id);

    void deleteUserById(Long user_id);

}
