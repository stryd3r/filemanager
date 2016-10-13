package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.QuestionnaireDao;
import com.filemanager.backend.service.interfaces.QuestionnaireService;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireDao dao;

	@Override
	public boolean insertQuestionnaire(QuestionnaireDto questionnaire) {
		return dao.insertQuestionnaire(questionnaire);
	}

	@Override
	public boolean updateQuestionnaire(QuestionnaireDto questionnaire, int oldQuestionnaireId, int oldQuestionId) {
		return dao.updateQuestionnaire(questionnaire, oldQuestionnaireId, oldQuestionId);
	}

	@Override
	public List<QuestionnaireDto> getQuestionnaires() {
		return dao.getQuestionnaires();
	}

	@Override
	public boolean removeQuestionFromQuestionnaire(int questionnaireId, int questionId) {
		return dao.removeQuestionFromQuestionnaire(questionnaireId, questionId);
	}

	@Override
	public QuestionnaireDto getQuestionFromQuestionnaire(int questionnaireId, int questionId) {
		return dao.getQuestionFromQuestionnaire(questionnaireId, questionId);
	}

	@Override
	public boolean removeQuestionnaire(int questionnaireId) {
		return dao.removeQuestionnaire(questionnaireId);
	}

	@Override
	public List<QuestionnaireDto> getQuestionnaire(int questionnaireId) {
		return dao.getQuestionnaire(questionnaireId);
	}

}
