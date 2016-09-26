package com.filemanager.utils.transporters.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.filemanager.utils.transporters.dto.CalendarDto;
import com.filemanager.utils.transporters.dto.ConsultationsDto;
import com.filemanager.utils.transporters.dto.DoctorsDto;
import com.filemanager.utils.transporters.dto.EventDto;
import com.filemanager.utils.transporters.dto.PacientsDetailsDto;
import com.filemanager.utils.transporters.dto.PacientsDto;
import com.filemanager.utils.transporters.dto.QuestionnaireAnswersDto;
import com.filemanager.utils.transporters.dto.QuestionnaireDto;
import com.filemanager.utils.transporters.dto.QuestionnairePKDto;
import com.filemanager.utils.transporters.entities.Calendar;
import com.filemanager.utils.transporters.entities.Consultations;
import com.filemanager.utils.transporters.entities.Doctors;
import com.filemanager.utils.transporters.entities.Event;
import com.filemanager.utils.transporters.entities.Pacients;
import com.filemanager.utils.transporters.entities.PacientsDetails;
import com.filemanager.utils.transporters.entities.Questionnaire;
import com.filemanager.utils.transporters.entities.QuestionnaireAnswers;
import com.filemanager.utils.transporters.entities.QuestionnairePK;

@Mapper
public interface PacientsMapper {

	PacientsDto entityToDto(Pacients input);

	@InheritInverseConfiguration
	Pacients dtoToEntity(PacientsDto input);

	PacientsDetailsDto entityToDto(PacientsDetails input);

	@InheritInverseConfiguration
	PacientsDetails dtoToEntity(PacientsDetailsDto input);

	DoctorsDto entityToDto(Doctors input);

	@InheritInverseConfiguration
	Doctors dtoToEntity(DoctorsDto input);

	CalendarDto entityToDto(Calendar input);

	@InheritInverseConfiguration
	Calendar dtoToEntity(CalendarDto input);

	EventDto entityToDto(Event input);

	@InheritInverseConfiguration
	Event dtoToEntity(EventDto input);

	ConsultationsDto entityToDto(Consultations input);

	@InheritInverseConfiguration
	Consultations dtoToEntity(ConsultationsDto input);

	QuestionnaireAnswersDto entityToDto(QuestionnaireAnswers input);

	@InheritInverseConfiguration
	QuestionnaireAnswers dtoToEntity(QuestionnaireAnswersDto input);

	QuestionnaireDto entityToDto(Questionnaire input);

	@InheritInverseConfiguration
	Questionnaire dtoToEntity(QuestionnaireDto input);

	QuestionnairePKDto entityToDto(QuestionnairePK input);

	@InheritInverseConfiguration
	QuestionnairePK dtoToEntity(QuestionnairePKDto input);

}
