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
import com.filemanager.utils.transporters.dto.PacientsDto;

@RunWith(SpringJUnit4ClassRunner.class)
// WebConfig is not loaded because jUnit is not working with @EnableWebMvc
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class MapperTest {

	@Autowired
	private PacientsService service;

	@Test
	public void test() {
		List<PacientsDto> pacients = service.getPacients(false, false);

		System.out.println("ok");
	}

}
