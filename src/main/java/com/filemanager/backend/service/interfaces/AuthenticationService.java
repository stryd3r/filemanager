package com.filemanager.backend.service.interfaces;

import com.filemanager.utils.transporters.model.CredentialModel;

public interface AuthenticationService {
	
	boolean login(CredentialModel credentialModel);
}
