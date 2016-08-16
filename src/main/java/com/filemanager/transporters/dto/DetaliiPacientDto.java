package com.filemanager.transporters.dto;

import java.io.Serializable;

public class DetaliiPacientDto implements Serializable {

	private static final long serialVersionUID = -332663002171084255L;
	private int idPacient;
	private String adresa;

	public int getIdPacient() {
		return idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
