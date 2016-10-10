package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.service.interfaces.QuestionnaireAnswerService;
import com.filemanager.backend.service.interfaces.QuestionnaireService;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

@RestController
public class QuestionnaireController {

	@Autowired
	private QuestionnaireService service;

	@Autowired
	private QuestionnaireAnswerService answersService;

	@RequestMapping(value = "/insertQuestionnaire", produces = "application/json")
	public boolean insertQuestionnaire(QuestionnaireDto questionnaire) {
		return service.insertQuestionnaire(questionnaire);
	}

	@RequestMapping(value = "/updateQuestionnaire", produces = "application/json")
	public boolean updateQuestionnaire(QuestionnaireDto questionnaire, int oldQuestionnaireId, int oldQuestionId) {
		return service.updateQuestionnaire(questionnaire, oldQuestionnaireId, oldQuestionId);
	}

	@RequestMapping(value = "/getQuestionnaires", produces = "application/json")
	public List<QuestionnaireDto> getQuestionnaires() {
		return service.getQuestionnaires();
	}

	@RequestMapping(value = "/removeQuestionFromQuestionnaire", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removeQuestionFromQuestionnaire(int questionnaireId, int questionId) {
		return service.removeQuestionFromQuestionnaire(questionnaireId, questionId);
	}

	@RequestMapping(value = "/getQuestionnaireById", produces = "application/json")
	public QuestionnaireDto getQuestionFromQuestionnaire(int questionnaireId, int questionId) {
		return service.getQuestionFromQuestionnaire(questionnaireId, questionId);
	}

	@RequestMapping(value = "/removeQuestionnaire", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removeQuestionnaire(int questionnaireId) {
		return service.removeQuestionnaire(questionnaireId);
	}

	@RequestMapping(value = "/getQuestionnaire", produces = "application/json")
	public List<QuestionnaireDto> getQuestionnaire(int questionnaireId) {
		return service.getQuestionnaire(questionnaireId);
	}

	@RequestMapping(value = "/insertQuestionnaireAnswer", produces = "application/json")
	public boolean insertQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer) {
		return answersService.insertQuestionnaireAnswer(questionnaireAnswer);
	}

	@RequestMapping(value = "/updateQuestionnaireAnswer", produces = "application/json")
	public boolean updateQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer, int oldQuestionnaireId, int oldQuestionId, int oldPacientId) {
		return answersService.updateQuestionnaireAnswer(questionnaireAnswer, oldQuestionnaireId, oldQuestionId, oldPacientId);
	}

	@RequestMapping(value = "/getQuestionnaireAnswers", produces = "application/json")
	public List<QuestionnaireAnswerDto> getQuestionnaireAnswers() {
		return answersService.getQuestionnaireAnswers();
	}

	@RequestMapping(value = "/removeQuestionnaireAnswer", produces = "application/json", method=RequestMethod.DELETE)
	public boolean removeQuestionnaireAnswer(int questionnaireAnswerId, int questionId, int pacientId) {
		return answersService.removeQuestionnaireAnswer(questionnaireAnswerId, questionId, pacientId);
	}

	@RequestMapping(value = "/getAnswer", produces = "application/json")
	public QuestionnaireAnswerDto getAnswer(int questionnaireAnswerId, int questionId, int pacientId) {
		return answersService.getAnswer(questionnaireAnswerId, questionId, pacientId);
	}

	@RequestMapping(value = "/getAnswersForQuestionnaire", produces = "application/json")
	public List<QuestionnaireAnswerDto> getAnswersForQuestionnaire(int questionnaireAnswerId, int pacientId) {
		return answersService.getAnswersForQuestionnaire(questionnaireAnswerId, pacientId);
	}
}
