package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.PacientDto;

public class PacientMapper implements RowMapper<PacientDto> {

	public PacientDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PacientDto pacient = new PacientDto();
		pacient.setPacientId(rs.getInt("pacientId"));
		pacient.setName(rs.getString("name"));
		pacient.setSurname(rs.getString("surname"));
		pacient.setDoctorId(rs.getInt("doctorId"));
		return pacient;
	}
}
