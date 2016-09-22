package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the consultatii database table.
 * 
 */
@Entity
@NamedQuery(name = "Consultations.findAll", query = "SELECT c FROM Consultations c")
public class Consultations implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int consultationId;

	private String diagnostic;

	private String observatii;

	private String pret;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId")
	private Doctors doctor;

	// bi-directional many-to-one association to Pacienti
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacientId")
	private Pacients pacient;

	public Consultations() {
	}

	public int getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(int consultationId) {
		this.consultationId = consultationId;
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

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public Pacients getPacient() {
		return pacient;
	}

	public void setPacient(Pacients pacient) {
		this.pacient = pacient;
	}

}