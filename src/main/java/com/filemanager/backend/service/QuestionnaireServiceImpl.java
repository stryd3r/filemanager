package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.QuestionnaireAnswerDao;
import com.filemanager.backend.dao.interfaces.QuestionnaireDao;
import com.filemanager.backend.service.interfaces.QuestionnaireService;
import com.filemanager.exceptions.ConstraintException;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireDao dao;

	@Autowired
	private QuestionnaireAnswerDao questionnaireAnswerDao;

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
	public boolean removeQuestionnaire(int questionnaireId) throws ConstraintException {
		checkIfconstraintsPassed(questionnaireId);
		return dao.removeQuestionnaire(questionnaireId);
	}

	private void checkIfconstraintsPassed(int questionnaireId) throws ConstraintException {
		boolean result = questionnaireAnswerDao.checkIfQuestionnaireCanBeDeleted(questionnaireId);
		if (!result) {
			throw new ConstraintException("Chestionarul nu poate fi sters deoarece cel putin un pacient l-a completat!");
		}

	}

	@Override
	public List<QuestionnaireDto> getQuestionnaire(int questionnaireId) {
		return dao.getQuestionnaire(questionnaireId);
	}

}
