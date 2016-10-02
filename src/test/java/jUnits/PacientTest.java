package jUnits;

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
import com.filemanager.utils.transporters.entities.Doctor;
import com.filemanager.utils.transporters.entities.Pacient;
import com.filemanager.utils.transporters.entities.PacientDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PacientTest {

	@Autowired
	private PacientsService pacientService;
	int validPacientId = 11;
	int validDoctorId = 1;

	@Test
	public void insertPacient() {
		Pacient pacient = new Pacient();
		pacient.setName("test");
		pacient.setSurname("test");
		Doctor doctor = new Doctor(validDoctorId);
		pacient.setDoctor(doctor);
		PacientDetail pacientDetail = new PacientDetail();
		pacientDetail.setAddress("test");
		pacient.setPacientDetail(pacientDetail);
		pacientService.insertPacient(pacient);

		boolean success = pacientService.deletePacient(pacient);
		assert (success);
	}

	@Test
	public void getOnlyPacientsTest() {
		List<Pacient> pacients = pacientService.getPacients(false, false, false);

		assert (pacients != null && pacients.size() > 0);
	}

	@Test
	public void getPacientById() {
		Pacient pacient = pacientService.getPacientById(validPacientId, true, true, true);

		assert (pacient != null);
	}

	@Test
	public void getPacientsWithDoctorAndDetails() {
		List<Pacient> pacients = pacientService.getPacients(true, true, true);
		boolean pacientIsSet = pacients != null && pacients.size() > 0;
		boolean pacientDetailsIsSet = pacients.get(0).getPacientDetail().getAddress() != null;
		boolean doctorIsSet = pacients.get(0).getDoctor().getName() != null;

		assert (pacientIsSet && pacientDetailsIsSet && doctorIsSet);
	}

	/*
	 * @Test public void deletePacient(){ Pacient pacient=new Pacient(); pacient.setPacientId(validPacientId); pacientService.deletePacient(pacient); }
	 */
}
