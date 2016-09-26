package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the raspuns_chestionar database table.
 * 
 */
@Entity
@Table
@NamedQuery(name = "QuestionnaireAnswers.findAll", query = "SELECT r FROM QuestionnaireAnswers r")
public class QuestionnaireAnswers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionnaireAnswerId;

	private String answer;

	// bi-directional many-to-one association to Chestionare
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "questionnaireId", referencedColumnName = "questionnaireId"), @JoinColumn(name = "questionId", referencedColumnName = "questionId") })
	private Questionnaire questionnaire;

	// bi-directional many-to-one association to Pacienti
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacientId")
	private Pacients pacient;

	public QuestionnaireAnswers() {
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public int getQuestionnaireAnswerId() {
		return questionnaireAnswerId;
	}

	public void setQuestionnaireAnswerId(int questionnaireAnswerId) {
		this.questionnaireAnswerId = questionnaireAnswerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Pacients getPacient() {
		return pacient;
	}

	public void setPacient(Pacients pacient) {
		this.pacient = pacient;
	}

}