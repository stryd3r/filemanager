package com.filemanager.utils.transporters.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the consultatii database table.
 * 
 */
@Entity
@NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")
public class Consultation implements Serializable {
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
	@Cascade(value = { CascadeType.MERGE})
	@JsonBackReference
	private Doctor doctor;

	// bi-directional many-to-one association to Pacienti
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacientId")
	@Cascade(value = { CascadeType.MERGE})
	@JsonBackReference
	private Pacient pacient;

	public Consultation() {
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
		this.pacient.addConsultation(this);
	}

}