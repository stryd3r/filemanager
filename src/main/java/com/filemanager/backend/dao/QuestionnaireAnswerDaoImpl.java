package com.filemanager.backend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.QuestionnaireAnswerDao;
import com.filemanager.utils.transporters.dto.simple.QuestionnaireAnswerDto;
import com.filemanager.utils.transporters.mappers.QuestionnaireAnswerMapper;

@Repository
public class QuestionnaireAnswerDaoImpl implements QuestionnaireAnswerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final private static String QUESTIONNAIRE_ANSWER_TABLE_NAME = "questionnaireAnswer";
	final private static String QUESTIONNAIRE_ID = "questionnaireId";
	final private static String QUESTION_ID = "questionId";
	final private static String ANSWER = "answer";
	final private static String PACIENT_ID = "pacientId";

	final private static String WHERE_NOT_DELETED = " WHERE deleted IS NULL";
	final private static String AND_NOT_DELETED = " AND deleted IS NULL";
	final private static String DELETE = " SET deleted = 1";

	@Override
	public boolean insertQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(QUESTIONNAIRE_ANSWER_TABLE_NAME);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(QUESTIONNAIRE_ID, questionnaireAnswer.getQuestionId());
		parameters.put(QUESTION_ID, questionnaireAnswer.getQuestionId());
		parameters.put(ANSWER, questionnaireAnswer.getAnswer());
		parameters.put(PACIENT_ID, questionnaireAnswer.getPacientId());
		// execute insert
		jdbcInsert.execute(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return true;
	}

	@Override
	public boolean updateQuestionnaireAnswer(QuestionnaireAnswerDto questionnaireAnswer, int oldQuestionnaireId, int oldQuestionId, int oldPacientId) {
		String sql = "UPDATE " + QUESTIONNAIRE_ANSWER_TABLE_NAME + " SET " + PACIENT_ID + "=?, " + QUESTIONNAIRE_ID + "=?, " + QUESTION_ID + "=?, " + ANSWER + "=?" + " WHERE " + QUESTIONNAIRE_ID + "="
				+ oldQuestionnaireId + " AND " + QUESTION_ID + "=" + oldQuestionId + " AND " + PACIENT_ID + "=" + oldPacientId + AND_NOT_DELETED;

		Object[] args = new Object[] { questionnaireAnswer.getPacientId(), questionnaireAnswer.getQuestionnaireId(), questionnaireAnswer.getQuestionId(), questionnaireAnswer.getAnswer() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success >= 1) ? true : false;
		return result;
	}

	@Override
	public List<QuestionnaireAnswerDto> getQuestionnaireAnswers() {
		String sql = "SELECT * FROM " + QUESTIONNAIRE_ANSWER_TABLE_NAME + WHERE_NOT_DELETED;

		List<QuestionnaireAnswerDto> questionnaireAnswers = jdbcTemplate.query(sql, new QuestionnaireAnswerMapper());

		return questionnaireAnswers;
	}

	@Override
	public QuestionnaireAnswerDto getAnswer(int questionnaireId, int questionId, int pacientId) {
		String sql = "SELECT * FROM " + QUESTIONNAIRE_ANSWER_TABLE_NAME + " WHERE " + QUESTIONNAIRE_ID + "=? AND " + QUESTION_ID + "=? AND " + PACIENT_ID + "=?" + AND_NOT_DELETED;
		Object[] args = new Object[] { questionnaireId, questionId, pacientId };
		QuestionnaireAnswerDto questionnaireAnswer = jdbcTemplate.queryForObject(sql, args, new QuestionnaireAnswerMapper());

		return questionnaireAnswer;
	}

	@Override
	public boolean removeQuestionnaireAnswer(int questionnaireId, int questionId, int pacientId) {
		String sql = "UPDATE " + QUESTIONNAIRE_ANSWER_TABLE_NAME + DELETE + " WHERE " + QUESTIONNAIRE_ID + " =? AND " + QUESTION_ID + " =? AND " + PACIENT_ID + " =?";

		Object[] args = new Object[] { questionnaireId, questionId, pacientId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

	@Override
	public List<QuestionnaireAnswerDto> getAnswersForQuestionnaire(int questionnaireId, int pacientId) {
		String sql = "SELECT * FROM " + QUESTIONNAIRE_ANSWER_TABLE_NAME + " WHERE " + QUESTIONNAIRE_ID + "=? AND " + PACIENT_ID + "=?" + AND_NOT_DELETED;
		Object[] args = new Object[] { questionnaireId, pacientId };
		List<QuestionnaireAnswerDto> answers = jdbcTemplate.query(sql, args, new QuestionnaireAnswerMapper());

		return answers;
	}

}
