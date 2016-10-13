package jUnits;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.filemanager.backend.service.interfaces.DoctorService;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.dto.complex.DoctorComplexDto;
import com.filemanager.utils.transporters.dto.simple.DoctorDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class DoctorTest {

	@Autowired
	private DoctorService service;
	int validPacientId = 1;
	int validDoctorId = 1;

	@Test
	public void insertRemoveDoctor() {
		DoctorDto doctor = new DoctorDto();
		doctor.setName("Adrian");
		doctor.setSurname("Barna");
		doctor.setColor("blue");
		int insertedId = service.insertDoctor(doctor);

		boolean result = service.removeDoctor(insertedId);

		assert (result);
	}

	@Test
	public void updateDoctor() {
		DoctorDto doctor = new DoctorDto();
		doctor.setDoctorId(validDoctorId);
		doctor.setName("Adrian");
		doctor.setSurname("Barna");
		doctor.setColor("blue");
		boolean result = service.updateDoctor(doctor);

		assert (result);
	}

	@Test
	public void getDoctorById() {

		DoctorDto doctor = service.getDoctorById(validDoctorId);

		assert (doctor != null);
	}

	@Test
	public void getDoctors() {

		List<DoctorDto> doctors = service.getDoctors();
		System.out.println(doctors.size());
		assert (doctors.size() > 0);
	}

	@Test
	public void getDoctorWithDetails() {
		DoctorComplexDto complexDoctor = service.getDoctorbyIdWithDetails(1, true, true, true);
		assert complexDoctor != null;
	}

	@Test
	public void getDoctorbyIdWithConsultationForPacient() {
		DoctorComplexDto complexDoctor = service.getDoctorbyIdWithConsultationForPacient(1, 1);
		assert complexDoctor != null;
	}

}
