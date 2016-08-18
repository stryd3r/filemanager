package com.filemanager.backend.repository;

import org.springframework.stereotype.Repository;

import com.filemanager.backend.repository.interfaces.AuthenticationRepository;
import com.filemanager.utils.transporters.model.CredentialModel;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

	@Override
	public boolean login(CredentialModel credentialModel) {
		return true;
	}

}
