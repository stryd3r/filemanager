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
import com.filemanager.utils.transporters.entities.Pacient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PacientsTest {

	@Autowired
	private PacientsService service;

	@Test
	public void getOnlyPacientsTest() {
		List<Pacient> pacients = service.getPacients(false, false, false);

		assert (pacients != null && pacients.size() > 0);
	}

	@Test
	public void getPacientsWithDoctorAndDetails() {
		List<Pacient> pacients = service.getPacients(true, true, true);
		boolean pacientIsSet = pacients != null && pacients.size() > 0;
		boolean pacientDetailsIsSet = pacients.get(0).getPacientDetail().getAddress() != null;
		boolean doctorIsSet = pacients.get(0).getDoctor().getName() != null;

		assert (pacientIsSet && pacientDetailsIsSet && doctorIsSet);
	}
}
