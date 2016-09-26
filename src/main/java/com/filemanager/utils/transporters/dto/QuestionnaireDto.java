package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the chestionare database table.
 * 
 */
public class QuestionnaireDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private QuestionnairePKDto id;

	private String question;

	private List<QuestionnaireAnswersDto> questionnaireAnswer;

	public QuestionnaireDto() {
	}

	public QuestionnairePKDto getId() {
		return this.id;
	}

	public void setId(QuestionnairePKDto id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<QuestionnaireAnswersDto> getQuestionnaireAnswer() {
		return questionnaireAnswer;
	}

	public void setQuestionnaireAnswer(List<QuestionnaireAnswersDto> questionnaireAnswer) {
		this.questionnaireAnswer = questionnaireAnswer;
	}

	public QuestionnaireAnswersDto addRaspunsChestionar(QuestionnaireAnswersDto raspunsChestionar) {
		getQuestionnaireAnswer().add(raspunsChestionar);
		raspunsChestionar.setQuestionnaire(this);

		return raspunsChestionar;
	}

	public QuestionnaireAnswersDto removeRaspunsChestionar(QuestionnaireAnswersDto raspunsChestionar) {
		getQuestionnaireAnswer().remove(raspunsChestionar);
		raspunsChestionar.setQuestionnaire(null);

		return raspunsChestionar;
	}

}