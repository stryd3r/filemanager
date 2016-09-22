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

@RunWith(SpringJUnit4ClassRunner.class)
//WebConfig is not loaded because jUnit is not working with @EnableWebMvc
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class DoctorsTest {

	@Autowired
	private PacientsService pacientiService;

	@Test
	public void firstTest() {
		pacientiService.getPacients(false, false);
		System.out.println("ok");
	}
}
