package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the pacienti database table.
 * 
 */
public class PacientsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pacientId;

	private String name;

	private String surname;

	private List<ConsultationsDto> consultations;

	private PacientsDetailsDto pacientDetail;

	private DoctorsDto doctor;

	private QuestionnaireAnswersDto questionnaireAnswer;

	public PacientsDto() {
	}

	public ConsultationsDto addConsultatii(ConsultationsDto consultatii) {
		getConsultations().add(consultatii);
		consultatii.setPacient(this);

		return consultatii;
	}

	public ConsultationsDto removeConsultatii(ConsultationsDto consultatii) {
		getConsultations().remove(consultatii);
		consultatii.setPacient(null);

		return consultatii;
	}

	public DoctorsDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorsDto doctor) {
		this.doctor = doctor;
	}

	public QuestionnaireAnswersDto getQuestionnaireAnswer() {
		return questionnaireAnswer;
	}

	public void setQuestionnaireAnswer(QuestionnaireAnswersDto questionnaireAnswer) {
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

	public List<ConsultationsDto> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<ConsultationsDto> consultations) {
		this.consultations = consultations;
	}

	public PacientsDetailsDto getPacientDetail() {
		return pacientDetail;
	}

	public void setPacientDetail(PacientsDetailsDto pacientDetail) {
		this.pacientDetail = pacientDetail;
	}

}