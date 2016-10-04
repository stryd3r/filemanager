package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.PacientDetailsDto;

public class PacientDetailsMapper implements RowMapper<PacientDetailsDto> {

	public PacientDetailsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PacientDetailsDto pacientDetails = new PacientDetailsDto();
		pacientDetails.setPacientId(rs.getInt("pacientId"));
		pacientDetails.setAddress(rs.getString("address"));
		pacientDetails.setAge(rs.getInt("age"));
		pacientDetails.setPhone(rs.getString("phone"));
		pacientDetails.setSex(rs.getString("sex"));
		pacientDetails.setZipCode(rs.getString("zipcode"));
		return pacientDetails;
	}
}
