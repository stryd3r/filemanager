package com.filemanager.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filemanager.transporters.model.QuestionModel;

@Service
public interface QuestionService {

	List<QuestionModel> getQuestions(boolean onlyUsed);

	boolean insertQuestion(QuestionModel question);

	boolean updateQuestion(QuestionModel question);

	boolean removeQuestion(int question);

}
