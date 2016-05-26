package com.filemanager.repository.interfaces;

import org.springframework.stereotype.Repository;

import com.filemanager.transporters.model.UserModel;

@Repository
public interface UserRepository {

	public UserModel findById(int id);

}
