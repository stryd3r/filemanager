package jUnits;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.filemanager.backend.dao.interfaces.ConsultationDao;
import com.filemanager.backend.service.interfaces.ConsultationService;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.dto.simple.ConsultationDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ConsultationTest {

	@Autowired
	private ConsultationDao dao;

	@Autowired
	private ConsultationService service;

	private static final int validConsultationId = 3;
	private static final int validDoctorId = 1;
	private static final int validPacientId = 1;

	@Test
	public void insertRemoveConsultation() {

		ConsultationDto consultation = new ConsultationDto();
		consultation.setDiagnostic("test");
		consultation.setDoctorId(validDoctorId);
		consultation.setPacientId(validPacientId);
		consultation.setObservation("obs");
		consultation.setPrice("100");
		consultation.setConsultationTime(new Timestamp(new Date().getTime()));
		int insertedId = dao.insertConsultation(consultation);

		boolean result = dao.removeConsultation(insertedId);

		assert (result);
	}

	@Test
	public void updateConsultation() {
		ConsultationDto consultation = new ConsultationDto();
		consultation.setConsultationId(validConsultationId);
		consultation.setDiagnostic("sad1");
		consultation.setDoctorId(validDoctorId);
		consultation.setPacientId(validPacientId);
		consultation.setObservation("obs2");
		consultation.setPrice("111");
		consultation.setConsultationTime(new Timestamp(new Date().getTime()));
		boolean result = dao.updateConsultation(consultation);

		assert (result);
	}

	@Test
	public void getConsultationById() {

		ConsultationDto consultation = dao.getConsultationById(validConsultationId);

		assert (consultation != null);
	}

	@Test
	public void getConsultations() {

		List<ConsultationDto> consultations = dao.getConsultations();
		System.out.println(consultations.size());
		assert (consultations.size() > 0);
	}

	@Test
	public void getConsultationsForPacient() {

		List<ConsultationDto> consultations = dao.getConsultationsForPacient(2);
		System.out.println(consultations.size());
		assert (consultations.size() > 0);
	}

	@Test
	public void deleteConsultation() {
		boolean result = service.removeConsultation(3);
		assert (result);
	}
	
	@Test
	public void removeConsultations() {
		int[] consultation={1,4};
		boolean result = service.removeConsultations(consultation);
		assert (result);
	}
	

}
