package com.filemanager.backend.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Consultatii implements Serializable{

	private static final long serialVersionUID = -7304535812360848960L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String diagnostic;
	private String observatii;
	private String pret;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pacienti pacient;

	@ManyToOne(fetch = FetchType.LAZY)
	private Doctori doctor;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pacienti getPacient() {
		return pacient;
	}

	public void setPacient(Pacienti pacient) {
		this.pacient = pacient;
	}

	public Doctori getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctori doctor) {
		this.doctor = doctor;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getObservatii() {
		return observatii;
	}

	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}

	public String getPret() {
		return pret;
	}

	public void setPret(String pret) {
		this.pret = pret;
	}

}
