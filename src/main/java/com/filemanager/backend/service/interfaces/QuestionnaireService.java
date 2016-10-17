package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.exceptions.ConstraintException;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

public interface QuestionnaireService {

	boolean insertQuestionnaire(QuestionnaireDto questionnaire);

	boolean updateQuestionnaire(QuestionnaireDto questionnaire, int oldQuestionnaireId, int oldQuestionId);

	List<QuestionnaireDto> getQuestionnaires();

	boolean removeQuestionFromQuestionnaire(int questionnaireId, int questionId);

	QuestionnaireDto getQuestionFromQuestionnaire(int questionnaireId, int questionId);

	boolean removeQuestionnaire(int questionnaireId) throws ConstraintException;

	List<QuestionnaireDto> getQuestionnaire(int questionnaireId);

}
