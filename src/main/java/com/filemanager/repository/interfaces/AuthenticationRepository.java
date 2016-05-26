package com.filemanager.repository.interfaces;

import org.springframework.stereotype.Repository;

import com.filemanager.transporters.model.CredentialModel;

@Repository
public interface AuthenticationRepository {
	
	boolean login(CredentialModel credentialModel);
}
