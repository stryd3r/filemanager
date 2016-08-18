package com.filemanager.utils.transporters.model;

import java.math.BigDecimal;

public class ConsultatieModel {

	private int id;
	private int idPacient;
	private int idDoctor;
	private String diagnostic;
	private String observatii;
	private BigDecimal pret;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPacient() {
		return idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
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

	public BigDecimal getPret() {
		return pret;
	}

	public void setPret(BigDecimal pret) {
		this.pret = pret;
	}

}
