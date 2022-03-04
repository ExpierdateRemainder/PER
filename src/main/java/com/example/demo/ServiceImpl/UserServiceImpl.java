package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.model.User;

@Service
@Primary

public class UserServiceImpl implements UserService{

	 private UserRepository userRepository;

	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	    
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long user_id) {
		// TODO Auto-generated method stub
		return userRepository.findById(user_id).get();
	}

	@Override
	public User pushUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	@Override
	public User updateUser(User updatedUser, Long user_id) {
		// TODO Auto-generated method stub
		userRepository.getById(user_id);
		updatedUser.setId(user_id);
		return userRepository.save(updatedUser);
	}

	@Override
	public void deleteUserById(Long user_id) {
		// TODO Auto-generated method stub
		  userRepository.deleteById(user_id);
		
	}

}
