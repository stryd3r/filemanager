package com.filemanager.utils.transporters.entities;

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

	private String observations;

	private String price;

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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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