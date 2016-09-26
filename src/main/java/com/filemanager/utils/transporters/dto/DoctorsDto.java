package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the doctori database table.
 * 
 */
public class DoctorsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int doctorId;

	private String name;

	private String surname;

	private CalendarDto calendar;

	private List<ConsultationsDto> consultations;

	private List<PacientsDto> pacients;

	public DoctorsDto() {
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public ConsultationsDto addConsultatii(ConsultationsDto consultatii) {
		getConsultations().add(consultatii);
		consultatii.setDoctor(this);

		return consultatii;
	}

	public ConsultationsDto removeConsultatii(ConsultationsDto consultatii) {
		getConsultations().remove(consultatii);
		consultatii.setDoctor(null);

		return consultatii;
	}

	public PacientsDto addPacienti(PacientsDto pacienti) {
		getPacients().add(pacienti);
		pacienti.setDoctor(this);

		return pacienti;
	}

	public PacientsDto removePacienti(PacientsDto pacienti) {
		getPacients().remove(pacienti);
		pacienti.setDoctor(null);

		return pacienti;
	}

	public CalendarDto getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarDto calendar) {
		this.calendar = calendar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<ConsultationsDto> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<ConsultationsDto> consultations) {
		this.consultations = consultations;
	}

	public List<PacientsDto> getPacients() {
		return pacients;
	}

	public void setPacients(List<PacientsDto> pacients) {
		this.pacients = pacients;
	}

}