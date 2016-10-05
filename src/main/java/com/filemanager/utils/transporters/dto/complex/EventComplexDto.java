package com.filemanager.utils.transporters.dto.complex;

import com.filemanager.utils.transporters.dto.simple.DoctorDto;
import com.filemanager.utils.transporters.dto.simple.EventDto;

public class EventComplexDto extends EventDto {

	private DoctorDto doctor;

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}

}
