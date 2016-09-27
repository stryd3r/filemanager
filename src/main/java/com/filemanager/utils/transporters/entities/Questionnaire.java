package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

/**
 * The persistent class for the chestionare database table.
 * 
 */
@Entity
@NamedQuery(name = "Questionnaire.findAll", query = "SELECT c FROM Questionnaire c")
public class Questionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestionnairePK id;

	private String question;

	// bi-directional many-to-one association to RaspunsChestionar
	@OneToMany(mappedBy = "questionnaire")
	@Cascade(value = { CascadeType.MERGE})
	private List<QuestionnaireAnswer> questionnaireAnswer;

	public Questionnaire() {
	}

	public QuestionnairePK getId() {
		return this.id;
	}

	public void setId(QuestionnairePK id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<QuestionnaireAnswer> getQuestionnaireAnswer() {
		return questionnaireAnswer;
	}

	public void setQuestionnaireAnswer(List<QuestionnaireAnswer> questionnaireAnswer) {
		this.questionnaireAnswer = questionnaireAnswer;
	}

	public QuestionnaireAnswer addRaspunsChestionar(QuestionnaireAnswer raspunsChestionar) {
		getQuestionnaireAnswer().add(raspunsChestionar);
		raspunsChestionar.setQuestionnaire(this);

		return raspunsChestionar;
	}

	public QuestionnaireAnswer removeRaspunsChestionar(QuestionnaireAnswer raspunsChestionar) {
		getQuestionnaireAnswer().remove(raspunsChestionar);
		raspunsChestionar.setQuestionnaire(null);

		return raspunsChestionar;
	}

}