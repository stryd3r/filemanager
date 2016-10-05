package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;

public class QuestionnaireAnswerMapper implements RowMapper<QuestionnaireAnswerDto> {

	public QuestionnaireAnswerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionnaireAnswerDto questionnaireAnswer = new QuestionnaireAnswerDto();
		questionnaireAnswer.setQuestionId(rs.getInt("questionId"));
		questionnaireAnswer.setQuestionnaireId(rs.getInt("questionnaireId"));
		questionnaireAnswer.setPacientId(rs.getInt("pacientId"));
		questionnaireAnswer.setAnswer(rs.getString("answer"));
		return questionnaireAnswer;
	}
}
