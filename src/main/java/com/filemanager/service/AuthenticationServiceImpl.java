package com.filemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.repository.interfaces.AuthenticationRepository;
import com.filemanager.service.interfaces.AuthenticationService;
import com.filemanager.transporters.model.CredentialModel;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationRepository authenticationRepository;

	@Override
	public boolean login(CredentialModel credentialModel) {
		return authenticationRepository.login(credentialModel);
	}

}
