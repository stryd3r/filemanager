package jUnits;

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
public class PacientDeleteTest {

	@Autowired
	private PacientsService pacientService;
	int validPacientId = 10;

	@Test
	public void deletePacient() {
		Pacient pacient = new Pacient();
		pacient.setPacientId(validPacientId);
		pacientService.deletePacient(pacient);
	}
}
