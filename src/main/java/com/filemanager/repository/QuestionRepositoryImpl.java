package com.filemanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.filemanager.model.QuestionModel;
import com.filemanager.repositoryInterfaces.QuestionRepository;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class QuestionMapper implements RowMapper<QuestionModel> {
		public QuestionModel mapRow(ResultSet row, int rowNum) throws SQLException {
			QuestionModel question = new QuestionModel();
			question.setId(row.getInt("id"));
			question.setQuestion(row.getString("question"));
			question.setAnswer(row.getString("answer"));
			return question;
		}
	}

	public List<QuestionModel> getQuestions(boolean onlyUsed) {
		List<QuestionModel> questionsList;
		if (onlyUsed) {
			String sql = "select * from questions where used=true";
			questionsList = jdbcTemplate.query(sql, new QuestionMapper());
		} else {
			String sql = "select * from questions";
			questionsList = jdbcTemplate.query(sql, new QuestionMapper());
		}
		return questionsList;
	}

	@Override
	public boolean insertQuestion(QuestionModel question) {

		String sql = "insert into questions (question,answer,used) values (?,?,?)";
		jdbcTemplate.update(sql, question.getQuestion(), question.getAnswer(), question.isUsed());
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateQuestion(QuestionModel question) {

		String sql = "update questions set answer=? where id=?";
		jdbcTemplate.update(sql, question.getAnswer(), question.getId());
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean removeQuestion(int questionId) {

		String sql = "delete from questions where id=?";
		jdbcTemplate.update(sql, questionId);
		// TODO Auto-generated method stub
		return true;
	}

}
