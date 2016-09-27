package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

/**
 * The persistent class for the doctori database table.
 * 
 */
@Entity
@NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;

	private String name;

	private String surname;

	private String color;

	// bi-directional many-to-one association to Calendar
	@OneToOne(mappedBy = "doctor", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private Calendar calendar;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<Consultation> consultations;

	// bi-directional many-to-one association to Pacienti
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Pacient> pacients;

	public Doctor() {
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Consultation addConsultatii(Consultation consultatii) {
		getConsultations().add(consultatii);
		consultatii.setDoctor(this);

		return consultatii;
	}

	public Consultation removeConsultatii(Consultation consultatii) {
		getConsultations().remove(consultatii);
		consultatii.setDoctor(null);

		return consultatii;
	}

	public Pacient addPacienti(Pacient pacienti) {
		getPacients().add(pacienti);
		pacienti.setDoctor(this);

		return pacienti;
	}

	public Pacient removePacienti(Pacient pacienti) {
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

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public List<Pacient> getPacients() {
		return pacients;
	}

	public void setPacients(List<Pacient> pacients) {
		this.pacients = pacients;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}