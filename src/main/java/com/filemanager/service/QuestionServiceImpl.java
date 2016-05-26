package com.filemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.repository.interfaces.QuestionRepository;
import com.filemanager.service.interfaces.QuestionService;
import com.filemanager.transporters.model.QuestionModel;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<QuestionModel> getQuestions(boolean onlyUsed) {
		return questionRepository.getQuestions(onlyUsed);
	}

	@Override
	public boolean insertQuestion(QuestionModel question) {

		return questionRepository.insertQuestion(question);
	}

	@Override
	public boolean updateQuestion(QuestionModel question) {

		return questionRepository.updateQuestion(question);
	}

	@Override
	public boolean removeQuestion(int questionId) {

		return questionRepository.removeQuestion(questionId);
	}

}
