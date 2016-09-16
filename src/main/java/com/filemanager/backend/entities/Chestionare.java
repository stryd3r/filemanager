package com.filemanager.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chestionare implements Serializable{

	private static final long serialVersionUID = 9179105130664404665L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Id
	@Column(name = "id_intrebare")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idIntrebare;

	private String intrebare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIntrebare() {
		return idIntrebare;
	}

	public void setIdIntrebare(int idIntrebare) {
		this.idIntrebare = idIntrebare;
	}

	public String getIntrebare() {
		return intrebare;
	}

	public void setIntrebare(String intrebare) {
		this.intrebare = intrebare;
	}

}
