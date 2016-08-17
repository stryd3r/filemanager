package com.filemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.repository.interfaces.AuthenticationRepository;
import com.filemanager.repository.interfaces.PacientiRepository;
import com.filemanager.service.interfaces.AuthenticationService;
import com.filemanager.transporters.model.CredentialModel;
import com.filemanager.transporters.model.PacientModel;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationRepository authenticationRepository;

	@Autowired
	private PacientiRepository repository;

	@Override
	public boolean login(CredentialModel credentialModel) {

		repository.save(new PacientModel());
		return authenticationRepository.login(credentialModel);
	}

}
