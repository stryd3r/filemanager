package com.filemanager.transporters.dto;

import java.io.Serializable;

public class RaspunsChestionarDto implements Serializable {

	private static final long serialVersionUID = 7788246691846091118L;
	private int idPacient;
	private int idChestionar;
	private int idIntrebare;
	private String raspuns;

	public int getIdPacient() {
		return idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}

	public int getIdChestionar() {
		return idChestionar;
	}

	public void setIdChestionar(int idChestionar) {
		this.idChestionar = idChestionar;
	}

	public int getIdIntrebare() {
		return idIntrebare;
	}

	public void setIdIntrebare(int idIntrebare) {
		this.idIntrebare = idIntrebare;
	}

	public String getRaspuns() {
		return raspuns;
	}

	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}

}
