package com.filemanager.transporters.dto;

import java.io.Serializable;

public class PacientDto extends DetaliiPacientDto implements Serializable{

	private static final long serialVersionUID = -986647579595008421L;
	private int id;
	private String nume;
	private String prenume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

}
