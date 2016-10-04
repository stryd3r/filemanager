package com.filemanager.backend.service.interfaces;

import java.util.List;

import com.filemanager.utils.transporters.entities.Consultation;

public interface ConsultationService {

	Consultation insertConsultation(Consultation consultation);
	
	boolean updateConsultation(Consultation consultation);
	
	boolean removeConsultation(Consultation consultation);
	
	List<Consultation> getConsultations(boolean withPacient, boolean withDoctor);
	
	public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor);

}
