package com.filemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.service.interfaces.AuthenticationService;
import com.filemanager.transporters.dto.CredentialDto;
import com.filemanager.transporters.transformers.CredentialTransformer;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@RequestMapping(value = "/login")
	public boolean removeQuestion(@RequestBody CredentialDto credentialDto) {

		return authenticationService.login(CredentialTransformer.getInstance().dtoToModel(credentialDto));
	}

}
