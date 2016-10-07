package com.filemanager.utils.transporters.dto.simple;

import java.sql.Timestamp;

public class PacientDetailsDto {

	private int pacientId;
	private String address;
	private String zipCode;
	private String phone;
	private Timestamp birthdate;
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getPacientId() {
		return pacientId;
	}

	public void setPacientId(int pacientId) {
		this.pacientId = pacientId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

}
