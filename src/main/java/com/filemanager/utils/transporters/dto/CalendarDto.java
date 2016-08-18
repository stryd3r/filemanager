package com.filemanager.utils.transporters.dto;

import java.io.Serializable;

public class CalendarDto implements Serializable {

	private static final long serialVersionUID = -4328575175832709704L;
	private int id;
	private int idDoctor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

}
