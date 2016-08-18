package com.filemanager.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pacienti {

	@Id
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
