package com.filemanager.service.interfaces;

import org.springframework.stereotype.Service;

import com.filemanager.transporters.model.CredentialModel;

@Service
public interface AuthenticationService {
	
	boolean login(CredentialModel credentialModel);
}
