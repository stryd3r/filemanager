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

import com.filemanager.backend.dao.interfaces.PacientDao;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.dto.simple.PacientDetailsDto;
import com.filemanager.utils.transporters.dto.simple.PacientDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PacientTest {

	@Autowired
	private PacientDao dao;
	int validPacientId = 1;
	int validDoctorId = 1;

	@Test
	public void insertRemovePacient() {
		PacientDto pacient = new PacientDto();
		pacient.setName("Adrian");
		pacient.setSurname("Barna");
		pacient.setDoctorId(validDoctorId);
		int insertedId = dao.insertPacient(pacient);

		boolean result = dao.removePacient(insertedId);

		assert (result);
	}

	@Test
	public void updatePacient() {
		PacientDto pacient = new PacientDto();
		pacient.setPacientId(validPacientId);
		pacient.setName("Adrian123");
		pacient.setSurname("Barna");
		pacient.setDoctorId(validDoctorId);
		boolean result = dao.updatePacient(pacient);

		assert (result);
	}

	@Test
	public void getPacientById() {

		PacientDto pacient = dao.getPacientById(validPacientId);

		assert (pacient != null);
	}

	@Test
	public void getPacients() {

		List<PacientDto> pacients = dao.getPacients();

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
		dao.insertPacientDetails(pacientDetail);

		boolean success = dao.removePacientDetails(validPacientId);

		assert (success);
	}

	@Test
	public void getPacientDetails() {
		PacientDetailsDto result = dao.getPacientDetails(validPacientId);

		assert (result != null);
	}

	@Test
	public void updatePacientDetails() {
		PacientDetailsDto pacientDetail = new PacientDetailsDto();
		pacientDetail.setPacientId(validPacientId);
		pacientDetail.setBirthdate(new Timestamp(new Date().getTime()));
		pacientDetail.setPhone("000");
		pacientDetail.setAddress("Lalelor");
		pacientDetail.setZipCode("600125");
		pacientDetail.setSex("m");
		boolean success = dao.updatePacientDetails(pacientDetail);
		assert (success);
	}

}
