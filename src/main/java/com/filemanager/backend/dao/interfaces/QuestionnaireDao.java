package com.filemanager.backend.dao.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

public interface QuestionnaireDao {

	boolean insertQuestionnaire(QuestionnaireDto questionnaire);

	boolean updateQuestionnaire(QuestionnaireDto questionnaire, int oldQuestionnaireId, int oldQuestionId);

	List<QuestionnaireDto> getQuestionnaires();

	boolean removeQuestionFromQuestionnaire(int questionnaireId, int questionId);

	QuestionnaireDto getQuestionFromQuestionnaire(int questionnaireId, int questionId);
	
	boolean removeQuestionnaire(int questionnaireId);
	
	List<QuestionnaireDto> getQuestionnaire(int questionnaireId);

}
