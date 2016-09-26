package com.filemanager.utils.transporters.dto;

import java.io.Serializable;

/**
 * The persistent class for the consultatii database table.
 * 
 */
public class ConsultationsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int consultationId;

	private String diagnostic;

	private String observations;

	private String price;

	private DoctorsDto doctor;

	private PacientsDto pacient;

	public ConsultationsDto() {
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

	public DoctorsDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorsDto doctor) {
		this.doctor = doctor;
	}

	public PacientsDto getPacient() {
		return pacient;
	}

	public void setPacient(PacientsDto pacient) {
		this.pacient = pacient;
	}

}