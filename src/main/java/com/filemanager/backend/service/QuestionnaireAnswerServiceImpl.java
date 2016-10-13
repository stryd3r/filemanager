package com.filemanager.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filemanager.backend.dao.interfaces.QuestionnaireAnswerDao;
import com.filemanager.backend.service.interfaces.QuestionnaireAnswerService;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionnaireAnswerServiceImpl implements QuestionnaireAnswerService {

	@Autowired
	private QuestionnaireAnswerDao dao;

	@Override
	public boolean insertQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer) {
		return dao.insertQuestionnaireAnswer(questionnaireAnswer);
	}

	@Override
	public boolean updateQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer, int oldQuestionnaireId, int oldQuestionId, int oldPacientId) {
		return dao.updateQuestionnaireAnswer(questionnaireAnswer, oldQuestionnaireId, oldQuestionId, oldPacientId);
	}

	@Override
	public List<QuestionnaireAnswerDto> getQuestionnaireAnswers() {
		return dao.getQuestionnaireAnswers();
	}

	@Override
	public boolean removeQuestionnaireAnswer(int questionnaireAnswerId, int questionId, int pacientId) {
		return dao.removeQuestionnaireAnswer(questionnaireAnswerId, questionId, pacientId);
	}

	@Override
	public QuestionnaireAnswerDto getAnswer(int questionnaireId, int questionId, int pacientId) {
		return dao.getAnswer(questionnaireId, questionId, pacientId);
	}

	@Override
	public List<QuestionnaireAnswerDto> getAnswersForQuestionnaire(int questionnaireId, int pacientId) {
		return dao.getAnswersForQuestionnaire(questionnaireId, pacientId);
	}
}
