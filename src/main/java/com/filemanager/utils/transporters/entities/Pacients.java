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

/**
 * The persistent class for the pacienti database table.
 * 
 */
@Entity
@NamedQuery(name = "Pacients.findAll", query = "SELECT p FROM Pacients p")
public class Pacients implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pacientId;

	private String name;

	private String surname;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "pacient")
	private List<Consultations> consultations;

	// bi-directional many-to-one association to DetaliiPacient
	@OneToOne(mappedBy = "pacient")
	@Cascade({ CascadeType.ALL })
	private PacientsDetails pacientDetail;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId")
	private Doctors doctor;

	// bi-directional many-to-one association to RaspunsChestionar
	@OneToOne(mappedBy = "pacient")
	private QuestionnaireAnswers questionnaireAnswer;

	public Pacients() {
	}

	public Consultations addConsultatii(Consultations consultatii) {
		getConsultations().add(consultatii);
		consultatii.setPacient(this);

		return consultatii;
	}

	public Consultations removeConsultatii(Consultations consultatii) {
		getConsultations().remove(consultatii);
		consultatii.setPacient(null);

		return consultatii;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public QuestionnaireAnswers getQuestionnaireAnswer() {
		return questionnaireAnswer;
	}

	public void setQuestionnaireAnswer(QuestionnaireAnswers questionnaireAnswer) {
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

	public List<Consultations> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultations> consultations) {
		this.consultations = consultations;
	}

	public PacientsDetails getPacientDetail() {
		return pacientDetail;
	}

	public void setPacientDetail(PacientsDetails pacientDetail) {
		this.pacientDetail = pacientDetail;
	}

}