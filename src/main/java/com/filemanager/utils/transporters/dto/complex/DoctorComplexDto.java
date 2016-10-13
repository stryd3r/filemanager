package com.filemanager.utils.transporters.dto.complex;

import java.util.List;

import com.filemanager.utils.transporters.dto.simple.ConsultationDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;
import com.filemanager.utils.transporters.dto.simple.EventDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

public class DoctorComplexDto extends DoctorDto {

	private List<PacientDto> pacients;
	private List<ConsultationDto> consultations;
	private List<EventDto> events;

	public List<PacientDto> getPacients() {
		return pacients;
	}

	public void setPacients(List<PacientDto> pacients) {
		this.pacients = pacients;
	}

	public List<ConsultationDto> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<ConsultationDto> consultations) {
		this.consultations = consultations;
	}

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}

}
