package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the doctori database table.
 * 
 */
@Entity
@NamedQuery(name = "Doctors.findAll", query = "SELECT d FROM Doctors d")
public class Doctors implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;

	private String name;

	private String surname;

	// bi-directional many-to-one association to Calendar
	@OneToOne(mappedBy = "doctor")
	private Calendar calendar;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "doctor")
	private List<Consultations> consultations;

	// bi-directional many-to-one association to Pacienti
	@OneToMany(mappedBy = "doctor")
	private List<Pacients> pacients;

	public Doctors() {
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Consultations addConsultatii(Consultations consultatii) {
		getConsultations().add(consultatii);
		consultatii.setDoctor(this);

		return consultatii;
	}

	public Consultations removeConsultatii(Consultations consultatii) {
		getConsultations().remove(consultatii);
		consultatii.setDoctor(null);

		return consultatii;
	}

	public Pacients addPacienti(Pacients pacienti) {
		getPacients().add(pacienti);
		pacienti.setDoctor(this);

		return pacienti;
	}

	public Pacients removePacienti(Pacients pacienti) {
		getPacients().remove(pacienti);
		pacienti.setDoctor(null);

		return pacienti;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
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

	public List<Consultations> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultations> consultations) {
		this.consultations = consultations;
	}

	public List<Pacients> getPacients() {
		return pacients;
	}

	public void setPacients(List<Pacients> pacients) {
		this.pacients = pacients;
	}

}