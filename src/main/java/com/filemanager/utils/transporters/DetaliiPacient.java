package com.filemanager.utils.transporters;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the detalii_pacient database table.
 * 
 */
@Entity
@Table(name = "detalii_pacient")
@NamedQuery(name = "DetaliiPacient.findAll", query = "SELECT d FROM DetaliiPacient d")
public class DetaliiPacient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adresa;

	@OneToOne()
	@JoinColumn(name = "id_pacient")
	@JsonBackReference(value="detPac")
	private Pacienti pacienti;

	public DetaliiPacient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pacienti getPacienti() {
		return this.pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}

}