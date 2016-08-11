package com.filemanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.filemanager.repository.interfaces.UserRepository;
import com.filemanager.transporters.model.UserModel;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class UserMapper implements RowMapper<UserModel> {
		public UserModel mapRow(ResultSet row, int rowNum) throws SQLException {
			UserModel user = new UserModel();
			user.setId(row.getInt("id"));
			user.setName(row.getString("name"));
			user.setSurname(row.getString("surname"));
			return user;
		}
	}

	public UserModel findById(int id) {
		String sql = "select * from users where id=?";
		UserModel user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserMapper());
		return user;
	}

}
