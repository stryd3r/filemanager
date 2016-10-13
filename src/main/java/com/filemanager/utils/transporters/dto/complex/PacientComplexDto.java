package com.filemanager.utils.transporters.dto.complex;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.ConsultationDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

public class PacientComplexDto extends PacientDto {

	private List<ConsultationDto> consultations;
	private DoctorDto doctor;
	private PacientDetailsDto pacientDetailsDto;

	public List<ConsultationDto> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<ConsultationDto> consultations) {
		this.consultations = consultations;
	}

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}

	public PacientDetailsDto getPacientDetailsDto() {
		return pacientDetailsDto;
	}

	public void setPacientDetailsDto(PacientDetailsDto pacientDetailsDto) {
		this.pacientDetailsDto = pacientDetailsDto;
	}

}
