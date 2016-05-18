package com.filemanager.repositoryInterfaces;

import org.springframework.stereotype.Repository;

import com.filemanager.model.UserModel;

@Repository
public interface UserRepository {

	public UserModel findById(int id);

}
