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
import com.filemanager.utils.transporters.entities.Doctor;

@RunWith(SpringJUnit4ClassRunner.class)
// WebConfig is not loaded because jUnit is not working with @EnableWebMvc
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class DoctorTest {

	@Autowired
	private DoctorService doctorService;

	int validDoctorId = 1;

	@Test
	public void insertDoctor() {
		Doctor doctor = new Doctor();
		doctor.setName("test");
		doctor.setSurname("test");
		// the color from below has to be unique
		doctor.setColor("red".concat(String.valueOf(validDoctorId)));
		doctorService.insertDoctor(doctor);
		
		boolean result = doctorService.removeDoctor(doctor);
		assert (result);
	}

	@Test
	public void updateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setDoctorId(validDoctorId);
		doctor.setName("doc1");
		doctor.setSurname("Surname1");
		doctor.setColor("violet");
		boolean result = doctorService.updateDoctor(doctor);
		assert (result);
	}

	@Test
	public void getDoctors() {
		List<Doctor> doctors = doctorService.getDoctors(true, true, true);
		assert (doctors.size() > 0);
	}

}
