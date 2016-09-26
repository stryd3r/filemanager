package com.filemanager.utils.transporters.dto;

import java.io.Serializable;

/**
 * The persistent class for the raspuns_chestionar database table.
 * 
 */
public class QuestionnaireAnswersDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int questionnaireAnswerId;

	private String answer;

	private QuestionnaireDto questionnaire;

	private PacientsDto pacient;

	public QuestionnaireAnswersDto() {
	}

	public QuestionnaireDto getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(QuestionnaireDto questionnaire) {
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

	public PacientsDto getPacient() {
		return pacient;
	}

	public void setPacient(PacientsDto pacient) {
		this.pacient = pacient;
	}

}