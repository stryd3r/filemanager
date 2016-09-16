package com.filemanager.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalii_pacient")
public class DetaliiPacient implements Serializable{

	private static final long serialVersionUID = 2681343866547539547L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_pacient")
	private int idPacient;
	private String adresa;
	
	@OneToOne(mappedBy="doctor",fetch=FetchType.LAZY)
	private Pacienti pacient;
	

	public int getIdPacient() {
		return idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

}
