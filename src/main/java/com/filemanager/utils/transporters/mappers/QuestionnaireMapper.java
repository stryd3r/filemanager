package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;

public class QuestionnaireMapper implements RowMapper<QuestionnaireDto> {

	public QuestionnaireDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionnaireDto questionnaire = new QuestionnaireDto();
		questionnaire.setQuestionId(rs.getInt("questionId"));
		questionnaire.setQuestionnaireId(rs.getInt("questionnaireId"));
		questionnaire.setQuestion(rs.getString("question"));
		return questionnaire;
	}
}
