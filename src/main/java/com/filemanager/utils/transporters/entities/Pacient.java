package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the pacienti database table.
 * 
 */
@Entity
@NamedQuery(name = "Pacient.findAll", query = "SELECT p FROM Pacient p")
public class Pacient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pacientId;

	private String name;

	private String surname;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "pacient")
	private List<Consultation> consultations;

	// bi-directional many-to-one association to DetaliiPacient
	@OneToOne(mappedBy = "pacient")
	@Cascade(value = { CascadeType.ALL})
	private PacientDetail pacientDetail;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId")
	@JsonBackReference
	private Doctor doctor;

	// bi-directional many-to-one association to RaspunsChestionar
	@OneToOne(mappedBy = "pacient")
	private QuestionnaireAnswer questionnaireAnswer;

	public Pacient() {
	}

	public Consultation addConsultation(Consultation consultatii) {
		getConsultations().add(consultatii);
		consultatii.setPacient(this);

		return consultatii;
	}

	public Consultation removeConsultation(Consultation consultatii) {
		getConsultations().remove(consultatii);
		consultatii.setPacient(null);

		return consultatii;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public QuestionnaireAnswer getQuestionnaireAnswer() {
		return questionnaireAnswer;
	}

	public void setQuestionnaireAnswer(QuestionnaireAnswer questionnaireAnswer) {
		this.questionnaireAnswer = questionnaireAnswer;
	}

	public int getPacientId() {
		return pacientId;
	}

	public void setPacientId(int pacientId) {
		this.pacientId = pacientId;
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

	public PacientDetail getPacientDetail() {
		return pacientDetail;
	}

	public void setPacientDetail(PacientDetail pacientDetail) {
		this.pacientDetail = pacientDetail;
		this.pacientDetail.setPacient(this);
	}

}