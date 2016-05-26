package com.filemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.repository.interfaces.UserRepository;
import com.filemanager.service.interfaces.UserService;
import com.filemanager.transporters.model.UserModel;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	public UserModel findById(int id) {
		return userRepository.findById(id);
	}

}
