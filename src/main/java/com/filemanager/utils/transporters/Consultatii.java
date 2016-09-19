package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the consultatii database table.
 * 
 */
@Entity
@NamedQuery(name = "Consultatii.findAll", query = "SELECT c FROM Consultatii c")
public class Consultatii implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsultatiiPK id;

	private String diagnostic;

	private String observatii;

	private String pret;

	// bi-directional many-to-one association to Pacienti
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pacient", insertable = false, updatable = false)
	@JsonBackReference(value="conPac")
	private Pacienti pacienti;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor", insertable = false, updatable = false)
	@JsonBackReference(value="conDoc")
	private Doctori doctori;

	public Consultatii() {
	}

	public ConsultatiiPK getId() {
		return this.id;
	}

	public void setId(ConsultatiiPK id) {
		this.id = id;
	}

	public String getDiagnostic() {
		return this.diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getObservatii() {
		return this.observatii;
	}

	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}

	public String getPret() {
		return this.pret;
	}

	public void setPret(String pret) {
		this.pret = pret;
	}

	public Pacienti getPacienti() {
		return this.pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}

	public Doctori getDoctori() {
		return this.doctori;
	}

	public void setDoctori(Doctori doctori) {
		this.doctori = doctori;
	}

}