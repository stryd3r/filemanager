package com.filemanager.backend.repository.interfaces;

import com.filemanager.utils.transporters.model.CredentialModel;

public interface AuthenticationRepository {
	
	boolean login(CredentialModel credentialModel);
}
