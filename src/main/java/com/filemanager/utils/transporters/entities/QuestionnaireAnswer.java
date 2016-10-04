package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the raspuns_chestionar database table.
 * 
 */
@Entity
@Table
@NamedQuery(name = "QuestionnaireAnswer.findAll", query = "SELECT r FROM QuestionnaireAnswer r")
public class QuestionnaireAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionnaireAnswerId;

	private String answer;

	// bi-directional many-to-one association to Chestionare
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "questionnaireId", referencedColumnName = "questionnaireId"), @JoinColumn(name = "questionId", referencedColumnName = "questionId") })
	@Cascade(value = { CascadeType.MERGE})
	@JsonBackReference(value="questionnaireAnswerQuestionnaire")
	private Questionnaire questionnaire;

	// bi-directional many-to-one association to Pacienti
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacientId")
	@Cascade(value = { CascadeType.MERGE})
	private Pacient pacient;

	public QuestionnaireAnswer() {
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

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

}