package com.filemanager.backend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.QuestionnaireDao;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireDto;
import com.filemanager.utils.transporters.mappers.QuestionnaireMapper;

@Repository
public class QuestionnaireDaoImpl implements QuestionnaireDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final private static String QUESTIONNAIRE_TABLE_NAME = "questionnaire";
	final private static String QUESTIONNAIRE_ID = "questionnaireId";
	final private static String QUESTION_ID = "questionId";
	final private static String QUESTION = "question";

	final private static String WHERE_NOT_DELETED = " WHERE deleted IS NULL";
	final private static String AND_NOT_DELETED = " AND deleted IS NULL";
	final private static String DELETE = " SET deleted = 1";

	@Override
	public boolean insertQuestionnaire(QuestionnaireDto questionnaire) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(QUESTIONNAIRE_TABLE_NAME);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(QUESTIONNAIRE_ID, questionnaire.getQuestionId());
		parameters.put(QUESTION_ID, questionnaire.getQuestionId());
		parameters.put(QUESTION, questionnaire.getQuestion());
		// execute insert
		jdbcInsert.execute(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return true;
	}

	@Override
	public boolean updateQuestionnaire(QuestionnaireDto questionnaire, int oldQuestionnaireId, int oldQuestionId) {
		String sql = "UPDATE " + QUESTIONNAIRE_TABLE_NAME + " SET " + QUESTIONNAIRE_ID + "=?, " + QUESTION_ID + "=?, " + QUESTION + "=?" + " WHERE " + QUESTIONNAIRE_ID + "=" + oldQuestionnaireId
				+ " AND " + QUESTION_ID + "=" + oldQuestionId + AND_NOT_DELETED;

		Object[] args = new Object[] { questionnaire.getQuestionnaireId(), questionnaire.getQuestionId(), questionnaire.getQuestion() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success >= 1) ? true : false;
		return result;
	}

	@Override
	public List<QuestionnaireDto> getQuestionnaires() {
		String sql = "SELECT * FROM " + QUESTIONNAIRE_TABLE_NAME + WHERE_NOT_DELETED;

		List<QuestionnaireDto> questionnaireAnswers = jdbcTemplate.query(sql, new QuestionnaireMapper());

		return questionnaireAnswers;
	}

	@Override
	public boolean removeQuestionFromQuestionnaire(int questionnaireId, int questionId) {
		String sql = "UPDATE " + QUESTIONNAIRE_TABLE_NAME + DELETE + " WHERE " + QUESTIONNAIRE_ID + " =? AND " + QUESTION_ID + " =?";

		Object[] args = new Object[] { questionnaireId, questionId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

	@Override
	public QuestionnaireDto getQuestionFromQuestionnaire(int questionnaireId, int questionId) {
		String sql = "SELECT * FROM " + QUESTIONNAIRE_TABLE_NAME + " WHERE " + QUESTIONNAIRE_ID + "=? AND " + QUESTION_ID + "=?" + AND_NOT_DELETED;
		Object[] args = new Object[] { questionnaireId, questionId };
		QuestionnaireDto questionnaire = jdbcTemplate.queryForObject(sql, args, new QuestionnaireMapper());

		return questionnaire;
	}

	@Override
	public boolean removeQuestionnaire(int questionnaireId) {
		String sql = "UPDATE " + QUESTIONNAIRE_TABLE_NAME + DELETE + " WHERE " + QUESTIONNAIRE_ID + " =?";

		Object[] args = new Object[] { questionnaireId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

	@Override
	public List<QuestionnaireDto> getQuestionnaire(int questionnaireId) {
		String sql = "SELECT * FROM " + QUESTIONNAIRE_TABLE_NAME + " WHERE " + QUESTIONNAIRE_ID + "=?" + AND_NOT_DELETED;
		Object[] args = new Object[] { questionnaireId };
		List<QuestionnaireDto> questionnaires = jdbcTemplate.query(sql, args, new QuestionnaireMapper());

		return questionnaires;
	}

}
