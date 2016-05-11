package com.filemanager.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.filemanager.model.UserModel;

@Repository
public class TestRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class UserMapper implements RowMapper<UserModel> {
		public UserModel mapRow(ResultSet row, int rowNum) throws SQLException {
			UserModel user = new UserModel();
			user.setIndex(row.getInt("id"));
			user.setNume(row.getString("nume"));
			return user;
		}
	}

	public UserModel findById(int id) {
		String sql = "select * from test where id=?";
		UserModel user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserMapper());
		return user;
	}

}
