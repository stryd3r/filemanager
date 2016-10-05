package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.simple.DoctorDto;

public class DoctorMapper implements RowMapper<DoctorDto> {

	public DoctorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		DoctorDto doctor = new DoctorDto();
		doctor.setDoctorId(rs.getInt("doctorId"));
		doctor.setName(rs.getString("name"));
		doctor.setSurname(rs.getString("surname"));
		doctor.setColor(rs.getString("color"));
		return doctor;
	}
}
