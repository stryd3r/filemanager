package com.filemanager.backend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.utils.transporters.dto.simple.ConsultationDto;
import com.filemanager.utils.transporters.mappers.ConsultationMapper;

@Repository
public class ConsultationDaoImpl implements ConsultationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final private static String CONSULTATTION_TABLE_NAME = "consultation";
	final private static String CONSULTATION_ID = "consultationId";
	final private static String DOCTOR_ID = "doctorId";
	final private static String PACIENT_ID = "pacientId";
	final private static String DIAGNOSTIC = "diagnostic";
	final private static String OBSERVATION = "observation";
	final private static String PRICE = "price";
	final private static String CONSULTATION_TIME = "consultationTime";

	@Override
	public int insertConsultation(ConsultationDto consultation) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(CONSULTATTION_TABLE_NAME).usingGeneratedKeyColumns(CONSULTATION_ID);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(DOCTOR_ID, consultation.getDoctorId());
		parameters.put(PACIENT_ID, consultation.getPacientId());
		parameters.put(DIAGNOSTIC, consultation.getDiagnostic());
		parameters.put(OBSERVATION, consultation.getObservation());
		parameters.put(PRICE, consultation.getPrice());
		parameters.put(CONSULTATION_TIME, consultation.getConsultationTime());
		// execute insert
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		// convert Number to Int using ((Number) key).intValue()
		return ((Number) key).intValue();
	}

	@Override
	public boolean updateConsultation(ConsultationDto consultation) {
		String sql = "UPDATE " + CONSULTATTION_TABLE_NAME + " SET " + DOCTOR_ID + "=?," + PACIENT_ID + "=?, " + DIAGNOSTIC + "=?, " + OBSERVATION + "=? , " + CONSULTATION_TIME + "=? , " + PRICE
				+ "=? WHERE " + CONSULTATION_ID + "=?";

		Object[] args = new Object[] { consultation.getDoctorId(), consultation.getPacientId(), consultation.getDiagnostic(), consultation.getObservation(), consultation.getConsultationTime(),
				consultation.getPrice(), consultation.getConsultationId() };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success == 1) ? true : false;
		return result;
	}

	@Override
	public boolean removeConsultation(int consultationId) {
		String sql = "DELETE FROM " + CONSULTATTION_TABLE_NAME + " WHERE " + CONSULTATION_ID + " =?";
		Object[] args = new Object[] { consultationId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success == 1) ? true : false;
		return result;
	}

	@Override
	public List<ConsultationDto> getConsultations() {
		String sql = "SELECT * FROM " + CONSULTATTION_TABLE_NAME;
		List<ConsultationDto> consultations = jdbcTemplate.query(sql, new ConsultationMapper());

		return consultations;
	}

	@Override
	public ConsultationDto getConsultationById(int consultationId) {
		String sql = "SELECT * FROM " + CONSULTATTION_TABLE_NAME + " WHERE " + CONSULTATION_ID + "=?";
		Object[] args = new Object[] { consultationId };

		ConsultationDto consultation = jdbcTemplate.queryForObject(sql, args, new ConsultationMapper());

		return consultation;
	}

	@Override
	public List<ConsultationDto> getConsultationsForPacient(int pacientId) {
		String sql = "SELECT * FROM " + CONSULTATTION_TABLE_NAME + " WHERE " + PACIENT_ID + "=?";
		Object[] args = new Object[] { pacientId };
		List<ConsultationDto> consultations = jdbcTemplate.query(sql, args, new ConsultationMapper());

		return consultations;
	}

	@Override
	public boolean removeConsultationForPacient(int pacientId) {
		String sql = "DELETE FROM " + CONSULTATTION_TABLE_NAME + " WHERE " + PACIENT_ID + " =?";
		Object[] args = new Object[] { pacientId };
		int success = jdbcTemplate.update(sql, args);

		boolean result = (success == 1) ? true : false;
		return result;
	}

}
