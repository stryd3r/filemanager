package jUnits;

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
public class DoctorDeleteTest {

	@Autowired
	private DoctorService doctorService;

	int validDoctorId = 15;

	@Test
	public void deleteDoctor() {
		Doctor doctor = new Doctor();

		doctor.setDoctorId(validDoctorId);
		boolean result = doctorService.removeDoctor(doctor);
		assert (result);
	}

}
