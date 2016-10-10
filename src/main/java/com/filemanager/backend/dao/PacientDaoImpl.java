package com.filemanager.backend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.PacientDao;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;
import com.filemanager.utils.transporters.mappers.PacientDetailsMapper;
import com.filemanager.utils.transporters.mappers.PacientMapper;

@Repository
public class PacientDaoImpl implements PacientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final private static String PACIENT_TABLE_NAME = "pacient";
	final private static String PACIENT_DETAIL_TABLE_NAME = "pacientdetail";
	final private static String PACIENT_ID = "pacientId";
	final private static String NAME = "name";
	final private static String SURNAME = "surname";
	final private static String DOCTOR_ID = "doctorId";

	final private static String ADDRESS = "address";
	final private static String ZIPCODE = "zipcode";
	final private static String PHONE = "phone";
	final private static String BIRTHDATE = "birthdate";
	final private static String SEX = "sex";
	final private static String CNP = "cnp";

	@Override
	public int insertPacient(PacientDto pacient) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(PACIENT_TABLE_NAME).usingGeneratedKeyColumns(PACIENT_ID);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(NAME, pacient.getName());
		parameters.put(SURNAME, pacient.getSurname());
		parameters.put(DOCTOR_ID, pacient.getDoctorId());
		// execute insert
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return ((Number) key).intValue();
	}

	@Override
	public List<PacientDto> getPacients() {

		String sql = "SELECT * FROM " + PACIENT_TABLE_NAME;

		List<PacientDto> pacientsList = jdbcTemplate.query(sql, new PacientMapper());

		return pacientsList;

	}

	@Override
	public PacientDto getPacientById(int pacientId) {

		String sql = "SELECT * FROM " + PACIENT_TABLE_NAME + " WHERE " + PACIENT_ID + " =?";
		Object[] args = new Object[] { pacientId };
		PacientDto pacient = jdbcTemplate.queryForObject(sql, args, new PacientMapper());

		return pacient;

	}

	@Override
	public boolean removePacient(int pacientId) {
		String sql = "DELETE FROM " + PACIENT_TABLE_NAME + " WHERE " + PACIENT_ID + " =?";

		Object[] args = new Object[] { pacientId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

	@Override
	public boolean updatePacient(PacientDto pacient) {

		String sql = "UPDATE " + PACIENT_TABLE_NAME + " SET " + NAME + "=?, " + SURNAME + "=?, " + DOCTOR_ID + "=? WHERE " + PACIENT_ID + "=?";

		Object[] args = new Object[] { pacient.getName(), pacient.getSurname(), pacient.getDoctorId(), pacient.getPacientId() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success >= 1) ? true : false;
		return result;
	}

	@Override
	public boolean insertPacientDetails(PacientDetailsDto pacientDetails) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(PACIENT_DETAIL_TABLE_NAME);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(PACIENT_ID, pacientDetails.getPacientId());
		parameters.put(ADDRESS, pacientDetails.getAddress());
		parameters.put(ZIPCODE, pacientDetails.getZipCode());
		parameters.put(PHONE, pacientDetails.getPhone());
		parameters.put(BIRTHDATE, pacientDetails.getBirthdate());
		parameters.put(SEX, pacientDetails.getSex());
		parameters.put(CNP, pacientDetails.getCnp());
		// execute insert
		jdbcInsert.execute(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return true;
	}

	@Override
	public boolean updatePacientDetails(PacientDetailsDto pacientDetail) {
		String sql = "UPDATE " + PACIENT_DETAIL_TABLE_NAME + " SET " + ADDRESS + "=?, " + ZIPCODE + "=?, " + PHONE + "=?, " + BIRTHDATE + "=?, " + SEX + "=?, " + CNP + "=? WHERE " + PACIENT_ID + "=?";

		Object[] args = new Object[] { pacientDetail.getAddress(), pacientDetail.getZipCode(), pacientDetail.getPhone(), pacientDetail.getBirthdate(), pacientDetail.getSex(), pacientDetail.getCnp(),
				pacientDetail.getPacientId() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success >= 1) ? true : false;
		return result;
	}

	@Override
	public boolean removePacientDetails(int pacientId) {
		String sql = "DELETE FROM " + PACIENT_DETAIL_TABLE_NAME + " WHERE " + PACIENT_ID + " =?";

		Object[] args = new Object[] { pacientId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success > 0) ? true : false;
		return result;
	}

	@Override
	public PacientDetailsDto getPacientDetails(int pacientId) {
		String sql = "SELECT * FROM " + PACIENT_DETAIL_TABLE_NAME + " WHERE " + PACIENT_ID + " =?";
		Object[] args = new Object[] { pacientId };
		PacientDetailsDto pacient = jdbcTemplate.queryForObject(sql, args, new PacientDetailsMapper());

		return pacient;
	}

	@Override
	public List<PacientDto> getPacientsForDoctor(int doctorId) {

		String sql = "SELECT * FROM " + PACIENT_TABLE_NAME + " WHERE " + DOCTOR_ID + " =?";
		Object[] args = new Object[] { doctorId };
		List<PacientDto> pacients = jdbcTemplate.query(sql, args, new PacientMapper());

		return pacients;

	}

}
