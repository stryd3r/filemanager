package com.filemanager.utils.transporters.dto.complex;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

public class QuestionnaireComplexDto extends QuestionnaireDto {

	private List<QuestionnaireAnswerDto> questionnaireAnswers;

	public List<QuestionnaireAnswerDto> getQuestionnaireAnswers() {
		return questionnaireAnswers;
	}

	public void setQuestionnaireAnswers(List<QuestionnaireAnswerDto> questionnaireAnswers) {
		this.questionnaireAnswers = questionnaireAnswers;
	}

}
