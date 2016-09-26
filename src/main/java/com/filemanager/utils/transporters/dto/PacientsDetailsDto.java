package com.filemanager.utils.transporters.dto;

import java.io.Serializable;

/**
 * The persistent class for the detalii_pacient database table.
 * 
 */
public class PacientsDetailsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pacientDetailsId;

	private String address;

	private PacientsDto pacient;

	public PacientsDetailsDto() {
	}

	public PacientsDto getPacient() {
		return pacient;
	}

	public void setPacient(PacientsDto pacient) {
		this.pacient = pacient;
	}

	public int getPacientDetailsId() {
		return pacientDetailsId;
	}

	public void setPacientDetailsId(int pacientDetailsId) {
		this.pacientDetailsId = pacientDetailsId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}