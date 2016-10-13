package com.filemanager.utils.transporters.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.filemanager.utils.transporters.dto.simple.ConsultationDto;

public class ConsultationMapper implements RowMapper<ConsultationDto> {

	public ConsultationDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConsultationDto consultation = new ConsultationDto();
		consultation.setConsultationId(rs.getInt("consultationId"));
		consultation.setDoctorId(rs.getInt("doctorId"));
		consultation.setPacientId(rs.getInt("pacientId"));
		consultation.setDiagnostic(rs.getString("diagnostic"));
		consultation.setObservation(rs.getString("observation"));
		consultation.setPrice(rs.getString("price"));
		consultation.setConsultationTime(rs.getTimestamp("consultationTime"));
		return consultation;
	}
}
