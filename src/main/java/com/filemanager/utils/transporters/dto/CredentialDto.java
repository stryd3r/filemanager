package com.filemanager.utils.transporters.dto;

import java.io.Serializable;

public class CredentialDto implements Serializable {

	private static final long serialVersionUID = -9075312714581219079L;

	private String user;
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
