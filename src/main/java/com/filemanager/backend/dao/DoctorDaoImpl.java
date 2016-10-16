package com.filemanager.backend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.DoctorDao;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;
import com.filemanager.utils.transporters.mappers.DoctorMapper;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final private static String DOCTOR_TABLE_NAME = "doctor";
	final private static String DOCTOR_ID = "doctorId";
	final private static String NAME = "name";
	final private static String SURNAME = "surname";
	final private static String COLOR = "color";

	final private static String WHERE_NOT_DELETED = " WHERE deleted IS NULL";
	final private static String AND_NOT_DELETED = " AND deleted IS NULL";
	final private static String DELETE = " SET deleted = 1";

	@Override
	public int insertDoctor(DoctorDto doctor) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(DOCTOR_TABLE_NAME).usingGeneratedKeyColumns(DOCTOR_ID);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(NAME, doctor.getName());
		parameters.put(SURNAME, doctor.getSurname());
		parameters.put(COLOR, doctor.getColor());
		// execute insert
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return ((Number) key).intValue();
	}

	@Override
	public List<DoctorDto> getDoctors() {
		String sql = "SELECT * FROM " + DOCTOR_TABLE_NAME + WHERE_NOT_DELETED;
		List<DoctorDto> doctors = jdbcTemplate.query(sql, new DoctorMapper());

		return doctors;
	}

	@Override
	public DoctorDto getDoctorById(int doctorId) {
		String sql = "SELECT * FROM " + DOCTOR_TABLE_NAME + " WHERE " + DOCTOR_ID + "=?" + AND_NOT_DELETED;

		Object[] args = new Object[] { doctorId };

		DoctorDto doctor = jdbcTemplate.queryForObject(sql, args, new DoctorMapper());

		return doctor;
	}

	@Override
	public boolean updateDoctor(DoctorDto doctor) {
		String sql = "UPDATE " + DOCTOR_TABLE_NAME + " SET " + NAME + "=?, " + SURNAME + "=?, " + COLOR + "=? WHERE " + DOCTOR_ID + "=?" + AND_NOT_DELETED;

		Object[] args = new Object[] { doctor.getName(), doctor.getSurname(), doctor.getColor(), doctor.getDoctorId() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success >= 1) ? true : false;
		return result;
	}

	@Override
	public boolean removeDoctor(int doctorId) {
		String sql = "UPDATE " + DOCTOR_TABLE_NAME + DELETE + " WHERE " + DOCTOR_ID + " =?";
		Object[] args = new Object[] { doctorId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

}
