package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;

public interface QuestionnaireAnswerService {

	boolean insertQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer);

	boolean updateQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer, int oldQuestionnaireId, int oldQuestionId, int oldPacientId);

	List<QuestionnaireAnswerDto> getQuestionnaireAnswers();

	boolean removeQuestionnaireAnswer(int questionnaireAnswerId, int questionId, int pacientId);

	QuestionnaireAnswerDto getAnswer(int questionnaireId, int questionId, int pacientId);

	List<QuestionnaireAnswerDto> getAnswersForQuestionnaire(int questionnaireId, int pacientId);

}
