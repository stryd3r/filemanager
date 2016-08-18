package com.filemanager.utils.transporters.dto;

import java.io.Serializable;

public class ChestionarDto implements Serializable {

	private static final long serialVersionUID = 6813287405243828802L;
	private int id;
	private int idIntrebare;
	private String intrebare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIntrebare() {
		return idIntrebare;
	}

	public void setIdIntrebare(int idIntrebare) {
		this.idIntrebare = idIntrebare;
	}

	public String getIntrebare() {
		return intrebare;
	}

	public void setIntrebare(String intrebare) {
		this.intrebare = intrebare;
	}

}
