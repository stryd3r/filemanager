package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the consultatii database table.
 * 
 */
@Entity
@NamedQuery(name = "Consultatii.findAll", query = "SELECT c FROM Consultatii c")
public class Consultatii implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_consultatii")
	private int idConsultatii;

	private String diagnostic;

	private String observatii;

	private String pret;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor")
	private Doctori doctor;

	// bi-directional many-to-one association to Pacienti
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pacient")
	private Pacienti pacient;

	public Consultatii() {
	}

	public int getIdConsultatii() {
		return idConsultatii;
	}

	public void setIdConsultatii(int idConsultatii) {
		this.idConsultatii = idConsultatii;
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

	public Doctori getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctori doctor) {
		this.doctor = doctor;
	}

	public Pacienti getPacient() {
		return pacient;
	}

	public void setPacient(Pacienti pacient) {
		this.pacient = pacient;
	}

}