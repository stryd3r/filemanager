package com.filemanager.repository.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.filemanager.transporters.model.QuestionModel;

@Repository
public interface QuestionRepository {

	List<QuestionModel> getQuestions(boolean onlyUsed);

	boolean insertQuestion(QuestionModel question);

	boolean updateQuestion(QuestionModel question);

	boolean removeQuestion(int question);

}
