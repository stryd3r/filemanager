package com.filemanager.utils.transporters.generatedEntities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the pacienti database table.
 * 
 */
@Entity
@NamedQuery(name = "Pacienti.findAll", query = "SELECT p FROM Pacienti p")
public class Pacienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nume;

	private String prenume;

	// bi-directional one-to-one association to DetaliiPacient
	@OneToOne(mappedBy = "pacienti", fetch = FetchType.LAZY)
	private DetaliiPacient detaliiPacient;

	public Pacienti() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public DetaliiPacient getDetaliiPacient() {
		return this.detaliiPacient;
	}

	public void setDetaliiPacient(DetaliiPacient detaliiPacient) {
		this.detaliiPacient = detaliiPacient;
	}

}