package com.filemanager.repository;

import org.springframework.stereotype.Repository;

import com.filemanager.repository.interfaces.AuthenticationRepository;
import com.filemanager.transporters.model.CredentialModel;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

	@Override
	public boolean login(CredentialModel credentialModel) {
		return true;
	}

}
