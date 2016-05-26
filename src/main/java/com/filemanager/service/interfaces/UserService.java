package com.filemanager.service.interfaces;

import org.springframework.stereotype.Service;

import com.filemanager.transporters.model.UserModel;

@Service
public interface UserService {

	public UserModel findById(int id);

}
