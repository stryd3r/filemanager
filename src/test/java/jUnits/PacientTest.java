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

import com.filemanager.backend.service.interfaces.PacientsService;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.dto.complex.PacientComplexDto;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PacientTest {

	@Autowired
	private PacientsService service;
	int validPacientId = 4;
	int validDoctorId = 1;

	@Test
	public void insertRemovePacient() {
		PacientDto pacient = new PacientDto();
		pacient.setName("Adrian");
		pacient.setSurname("Barna");
		pacient.setDoctorId(validDoctorId);
		int insertedId = service.insertPacient(pacient);

		boolean result = service.removePacient(insertedId,false);

		assert (result);
	}

	@Test
	public void updatePacient() {
		PacientDto pacient = new PacientDto();
		pacient.setPacientId(validPacientId);
		pacient.setName("Adrian123");
		pacient.setSurname("Barna");
		pacient.setDoctorId(validDoctorId);
		boolean result = service.updatePacient(pacient);

		assert (result);
	}

	@Test
	public void getPacientById() {

		PacientDto pacient = service.getPacientById(validPacientId,true,true,true);

		assert (pacient != null);
	}

	@Test
	public void getPacients() {

		List<PacientComplexDto> pacients = service.getPacients(true,true,true);

		assert (pacients.size() > 0);
	}

	@Test
	public void insertRemovePacientDetails() {
		PacientDetailsDto pacientDetail = new PacientDetailsDto();
		pacientDetail.setPacientId(validPacientId);
		pacientDetail.setAddress("Lalelelor");
		pacientDetail.setBirthdate(new Timestamp(new Date().getTime()));
		pacientDetail.setPhone("075 198 49 42");
		pacientDetail.setSex("M");
		pacientDetail.setZipCode("600125");
		pacientDetail.setCnp("1881213046690");
		service.insertPacientDetails(pacientDetail);

		boolean success = service.removePacientDetails(validPacientId);

		assert (success);
	}

	@Test
	public void getPacientDetails() {
		PacientDetailsDto result = service.getPacientDetails(validPacientId);

		assert (result != null);
	}

	@Test
	public void updatePacientDetails() {
		PacientDetailsDto pacientDetail = new PacientDetailsDto();
		pacientDetail.setPacientId(2);
		pacientDetail.setBirthdate(new Timestamp(new Date().getTime()));
		pacientDetail.setPhone("0001");
		pacientDetail.setAddress("Lalelor1");
		pacientDetail.setZipCode("6001251");
		pacientDetail.setSex("f");
		pacientDetail.setCnp("1881213046691");
		boolean success = service.updatePacientDetails(pacientDetail);
		assert (success);
	}

}
