package com.filemanager.repositoryInterfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.filemanager.model.QuestionModel;

@Repository
public interface QuestionRepository {

	List<QuestionModel> getQuestions(boolean onlyUsed);

	boolean insertQuestion(QuestionModel question);

	boolean updateQuestion(QuestionModel question);

	boolean removeQuestion(int question);

}
