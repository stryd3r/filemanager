package com.filemanager.transporters.dto;

import java.io.Serializable;

public class WorkDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7985658832179932715L;

	private String occupation;
	private int experience; 

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
