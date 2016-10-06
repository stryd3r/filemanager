package com.filemanager.backend.service.interfaces;

import java.util.List;

public interface ConsultationService {

	boolean removeConsultation(int consultationId);

	boolean removeConsultations(List<Integer> consultation);
/*
	Consultation insertConsultation(Consultation consultation);
	
	boolean updateConsultation(Consultation consultation);
	
	
	List<Consultation> getConsultations(boolean withPacient, boolean withDoctor);
	
	public Consultation getConsultationById(int consultationId, boolean withPacient, boolean withDoctor);*/


}
